package org.soluvas.ldap.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.commons.pool.ObjectPool;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.ProgressStatus;
import org.soluvas.commons.inject.Filter;
import org.soluvas.commons.inject.Namespace;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.ldap.LdapRepository;
import org.soluvas.ldap.LdapUtils;
import org.soluvas.ldap.SocialPerson;

import com.google.common.base.Function;
import com.google.common.base.Strings;

/**
 * Fix invalid primaryShippingAddress and primaryBillingAddress on {@link SocialPerson} entries.
 *
 * @author ceefour
 */
@Command(scope="person", name="fixaddress", description="Fix invalid primaryShippingAddress and primaryBillingAddress on person entries.")
public class PersonFixAddressCommand extends TenantCommandSupport {

	@Inject @Namespace("person") @Filter("(repositoryMode=raw)")
	private LdapRepository<SocialPerson> personRepo;
	
	@Inject @Namespace("ldap")
	private ObjectPool<LdapConnection> ldapPool;

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final List<SocialPerson> people = personRepo.findAll();
		System.err.println(ansi().render("Checking addresses in @|bold,yellow %d|@ people...",
				people.size()));
		
		monitor.beginTask("Fixing addresses", people.size());
		for (final SocialPerson person : people) {
			boolean fixed = false;
			log.debug("Checking address of {} ({})", person.getId(), person.getName());
			// Fix address syntax
			final String oldShippingAddress = person.getPrimaryShippingAddress();
			if (oldShippingAddress != null) {
				final String newShippingAddress = oldShippingAddress.replace("uniqueIdentifier=", "").replace("uniqueidentifier=", "");
				if (!newShippingAddress.equals(oldShippingAddress)) {
					fixed = true;
				}
				person.setPrimaryShippingAddress(Strings.emptyToNull(newShippingAddress));
			}
			final String oldBillingAddress = person.getPrimaryBillingAddress();
			if (oldBillingAddress != null) {
				final String newBillingAddress = oldBillingAddress.replace("uniqueIdentifier=", "").replace("uniqueidentifier=", "");
				if (!newBillingAddress.equals(oldBillingAddress)) {
					fixed = true;
				}
				person.setPrimaryBillingAddress(Strings.emptyToNull(newBillingAddress));
			}
			// Fix invalid address reference
			final String personDn = personRepo.toDn(person.getId());
			if (person.getPrimaryShippingAddress() != null) {
				final String shippingDn = "uniqueIdentifier=" + person.getPrimaryShippingAddress() + ",ou=addresses," + personDn;
				fixed = fixed || LdapUtils.withConnection(ldapPool, new Function<LdapConnection, Boolean>() {
					@Override @Nullable
					public Boolean apply(@Nullable LdapConnection conn) {
						try {
							if (!conn.exists(shippingDn)) {
								person.setPrimaryShippingAddress(null);
								return true;
							}
							return false;
						} catch (LdapException e) {
							log.error("LDAP Error", e);
							return true;
						}
					}
				});
			}
			if (person.getPrimaryBillingAddress() != null) {
				final String billingDn = "uniqueIdentifier=" + person.getPrimaryBillingAddress() + ",ou=addresses," + personDn;
				fixed = fixed || LdapUtils.withConnection(ldapPool, new Function<LdapConnection, Boolean>() {
					@Override @Nullable
					public Boolean apply(@Nullable LdapConnection conn) {
						try {
							if (!conn.exists(billingDn)) {
								person.setPrimaryBillingAddress(null);
								return true;
							}
							return false;
						} catch (LdapException e) {
							log.error("LDAP Error", e);
							return true;
						}
					}
				});
			}
			// Add address reference, if exists
			final String firstAddressId = LdapUtils.withConnection(ldapPool, new Function<LdapConnection, String>() {
				@Override @Nullable
				public String apply(@Nullable LdapConnection conn) {
					try {
						final List<Entry> addressEntries = LdapUtils.asList(
								conn.search("ou=addresses," + personDn, "(uniqueIdentifier=*)", SearchScope.ONELEVEL, "uniqueIdentifier"));
						if (!addressEntries.isEmpty()) {
							return addressEntries.get(0).getDn().getRdn().getValue().getString();
						}
					} catch (LdapException e) {
						log.error("LDAP Error", e);
					}
					return null;
				}
			});
			if (person.getPrimaryShippingAddress() == null) {
				fixed = true;
				person.setPrimaryShippingAddress(firstAddressId);
			}
			if (person.getPrimaryBillingAddress() == null) {
				fixed = true;
				person.setPrimaryBillingAddress(firstAddressId);
			}
			
			if (fixed) {
				personRepo.modify(person);
				log.info("Fixed address of {}, oldShipping={}, newShipping={}, oldBilling={}, newBilling={}",
						person.getId(), oldShippingAddress, person.getPrimaryShippingAddress(),
						oldBillingAddress, person.getPrimaryBillingAddress());
				monitor.worked(1, ProgressStatus.OK);
			} else {
				monitor.worked(1, ProgressStatus.SKIPPED);
			}
		}
		monitor.done();

		return null;
	}

}

package org.soluvas.ldap;

import java.util.List;

import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

/**
 * Test {@link LdapRepository} for {@link SocialPerson}.
 * @author ceefour
 */
public class LdapRepositoryTest {

	private transient Logger log = LoggerFactory.getLogger(LdapRepositoryTest.class);
	private LdapNetworkConnection conn;
	private LdapRepository<SocialPerson> personRepo;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		conn = new LdapNetworkConnection("localhost", 10389);
		conn.bind("uid=admin,ou=system", "secret");
		personRepo = new LdapRepository<SocialPerson>(SocialPerson.class, conn, "ou=users,dc=aksimata,dc=com");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void findOne() {
		SocialPerson hendy = personRepo.findOne("hendy");
		Assert.assertNotNull(hendy);
		Assert.assertEquals("hendy", hendy.getId());
		Assert.assertEquals("Hendy Irawan", hendy.getName());
	}

	@Test
	public void findAll() {
		List<SocialPerson> people = personRepo.findAll();
		List<String> names = Lists.transform(people, new Function<SocialPerson, String>() {
			@Override
			public String apply(SocialPerson input) {
				return input.getId() + " (" + input.getName() + ")";
			}
		});
		log.info("Returned person objects: {}", names);
		Assert.assertNotNull(people);
		Assert.assertTrue(people.size() >= 2);
	}

	@Test
	public void delete() {
		SocialPerson liz = personRepo.findOne("liz");
		Assert.assertNotNull(liz);
		personRepo.delete("liz");
		SocialPerson deletedLiz = personRepo.findOne("liz");
		Assert.assertNull(deletedLiz);
	}

	@Test
	public void add() {
		SocialPerson liz = new SocialPerson("liz", "liz.lemon", "Liz", "Lemon");
		liz.setEmails(ImmutableSet.of("liz.lemon@example.com", "liz@example.com"));
		liz.setPhotoId("liz_lemon");
		liz.setFacebookId(123456L);
		liz.setFacebookUsername("liz.lemon");
		liz.setTwitterId(123456L);
		liz.setTwitterScreenName("liz.lemon");
		log.info("Input Person: {}", liz);
		
		SocialPerson newLiz = personRepo.add(liz);
		Assert.assertNotNull(newLiz);
		
		SocialPerson foundLiz = personRepo.findOne("liz");
		Assert.assertNotNull(foundLiz);
		Assert.assertEquals("liz", foundLiz.getId());
		Assert.assertEquals("Liz Lemon", foundLiz.getName());
	}

}

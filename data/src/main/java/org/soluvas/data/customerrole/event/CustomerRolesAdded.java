package org.soluvas.data.customerrole.event;

import org.soluvas.commons.CustomerRole;
import org.soluvas.push.TenantEvent;

import com.google.common.collect.ImmutableList;

/**
 * @author rudi
 *
 */
public class CustomerRolesAdded extends TenantEvent {
	
	private static final long serialVersionUID = 1L;
	
	private final ImmutableList<CustomerRole> customerRoles;
	
	public CustomerRolesAdded(String tenantId, ImmutableList<CustomerRole> customerRoles, String trackingId) {
		super(tenantId, trackingId);
		this.customerRoles = customerRoles;
	}
	
	public ImmutableList<CustomerRole> getCustomerRoles() {
		return customerRoles;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "CustomerRolesAdded ["
				+ (customerRoles != null ? "customerRoles="
						+ customerRoles.subList(0,
								Math.min(customerRoles.size(), maxLen)) : "")
				+ "]";
	}
	
}

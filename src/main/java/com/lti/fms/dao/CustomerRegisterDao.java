/**
 * 
 */
package com.lti.fms.dao;

import java.util.List;

import com.lti.fms.entities.CustomerRegistration;

/**
 * @author lntinfotech/Ashika Jinturkar
 *
 */
public interface CustomerRegisterDao {

	public CustomerRegistration createCustomer(CustomerRegistration customerRegistration);

	public CustomerRegistration updateCustomer(CustomerRegistration customerRegistration);

	public CustomerRegistration findCustomerById(int customerId);
	
	public List<CustomerRegistration> getallCustomers();
	
	public void deleteCustomerRegistration(Integer customerId);
}

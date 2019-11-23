/**
 * 
 */
package com.lti.fms.service;

import java.util.List;

import com.lti.fms.entities.CustomerRegistration;
import com.lti.fms.entities.User;

/**
 * @author lntinfotech/Ashika Jinturkar
 *
 */
public interface CustomerRegisterService {
	
	public CustomerRegistration createCustomer(CustomerRegistration customerRegistration);
	
	public CustomerRegistration updateCustomer(CustomerRegistration customerRegistration);
	
	public CustomerRegistration  findCustomerById(int customerId); 
	
	public List<CustomerRegistration> getallCustomers();
	
	public void deleteCustomerRegistration(Integer customerId);
	
}

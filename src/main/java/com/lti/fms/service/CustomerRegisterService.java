/**
 * 
 */
package com.lti.fms.service;

import com.lti.fms.entities.CustomerRegistration;
import com.lti.fms.entities.User;

/**
 * @author lntinfotech/Ashika Jinturkar
 *
 */
public interface CustomerRegisterService {
	
	CustomerRegistration createCustomer(CustomerRegistration customerRegistration);
	
}

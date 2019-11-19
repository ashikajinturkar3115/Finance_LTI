/**
 * 
 */
package com.lti.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.fms.dao.CustomerRegisterDao;
import com.lti.fms.entities.CustomerRegistration;

/**
 * @author lntinfotech/Ashika Jinturkar
 *
 */

@Service
@Transactional
public class CustomerRegisterServiceImpl implements CustomerRegisterService{
	
	@Autowired
	CustomerRegisterDao customerRegisterDao;

	@Override
	public CustomerRegistration createCustomer(CustomerRegistration customerRegistration) {
		
		return null;
	}

}

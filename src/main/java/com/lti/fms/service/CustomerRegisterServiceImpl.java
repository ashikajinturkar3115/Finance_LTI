/**
 * 
 */
package com.lti.fms.service;

import java.util.List;

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
		
		return customerRegisterDao.createCustomer(customerRegistration);
	}

	@Override
	public CustomerRegistration updateCustomer(CustomerRegistration customerRegistration) {
		
		return customerRegisterDao.updateCustomer(customerRegistration);
	}

	@Override
	public CustomerRegistration findCustomerById(int customerId) {
		
		return customerRegisterDao.findCustomerById(customerId);
	}

	@Override
	public List<CustomerRegistration> getallCustomers() {
	
		return customerRegisterDao.getallCustomers();
	}

	@Override
	public void deleteCustomerRegistration(Integer customerId) {
		customerRegisterDao.deleteCustomerRegistration(customerId);
	}

}

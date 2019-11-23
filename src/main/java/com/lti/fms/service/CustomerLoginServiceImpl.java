/**
 * 
 */
package com.lti.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.fms.dao.CustomerLoginDao;
import com.lti.fms.entities.CustomerLogin;

/**
 * @author lntinfotech
 *
 */

@Service
@Transactional
public class CustomerLoginServiceImpl implements CustomerLoginService {

	@Autowired
	private CustomerLoginDao customerLoginDao;

	@Override
	public CustomerLogin createCustomerLogin(CustomerLogin customerLogin) {

		return customerLoginDao.createCustomerLogin(customerLogin);
	}

	@Override
	public List<CustomerLogin> getAllCustomerLogins() {

		return customerLoginDao.getAllCustomerLogins();
	}

	@Override
	public CustomerLogin findCustomerLoginById(int customerLoginId) {

		return customerLoginDao.findCustomerLoginById(customerLoginId);
	}

	@Override
	public CustomerLogin updateCustomerLogin(CustomerLogin customerLogin) {

		return customerLoginDao.updateCustomerLogin(customerLogin);
	}

	@Override
	public CustomerLogin findUserByUserName(String username) {

		return customerLoginDao.findUserByUserName(username);
	}

	@Override
	public CustomerLogin updatePassword(int CustomerLoginId, String newpassword) {

		return customerLoginDao.updatePassword(CustomerLoginId, newpassword);
	}

}

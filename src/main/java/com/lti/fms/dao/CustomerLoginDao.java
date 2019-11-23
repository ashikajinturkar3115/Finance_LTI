/**
 * 
 */
package com.lti.fms.dao;

import java.util.List;

import com.lti.fms.entities.CustomerLogin;

/**
 * @author lntinfotech
 *
 */
public interface CustomerLoginDao {
	CustomerLogin createCustomerLogin(CustomerLogin customerLogin);

	// List<CustomerLogin> allUsers();
	public List<CustomerLogin> getAllCustomerLogins();

	public CustomerLogin findCustomerLoginById(int customerLoginId);

	public CustomerLogin updateCustomerLogin(CustomerLogin customerLogin);

	public CustomerLogin findUserByUserName(String username);

	public CustomerLogin updatePassword(int CustomerLoginId, String newpassword);
}

/**
 * 
 */
package com.lti.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.fms.entities.CustomerRegistration;

/**
 * @author lntinfotech/Ashika Jinturkar
 *
 */

@Repository
public class CustomerRegisterDaoImpl implements CustomerRegisterDao{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public CustomerRegistration createCustomer(CustomerRegistration customerRegistration) {
		entityManager.merge(customerRegistration);
		return customerRegistration;
	}

}

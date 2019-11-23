/**
 * 
 */
package com.lti.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.lti.fms.entities.CustomerRegistration;

/**
 * @author lntinfotech/Ashika Jinturkar
 *
 */

@Repository
public class CustomerRegisterDaoImpl implements CustomerRegisterDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public CustomerRegistration createCustomer(CustomerRegistration customerRegistration) {

		entityManager.persist(customerRegistration);
		entityManager.flush();
		return customerRegistration;
	}

	@Override
	public CustomerRegistration updateCustomer(CustomerRegistration customerRegistration) {
		
		entityManager.merge(customerRegistration);
		
		return customerRegistration;
	}

	@Override
	public CustomerRegistration findCustomerById(int customerId) {
		CustomerRegistration customerRegistration = entityManager.find(CustomerRegistration.class, customerId);
		return customerRegistration;
	}

	@Override
	public List<CustomerRegistration> getallCustomers() {
		Query q = entityManager.createQuery("from CustomerRegistration");
		List<CustomerRegistration> list = q.getResultList();
		return list;
	}

	@Override
	public void deleteCustomerRegistration(Integer customerId) {
		CustomerRegistration customerRegistration = entityManager.find(CustomerRegistration.class,customerId);
		
		entityManager.remove(customerRegistration);
	}

}

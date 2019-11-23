/**
 * 
 */
package com.lti.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.lti.fms.entities.CustomerLogin;

/**
 * @author lntinfotech
 *
 */
@Repository
public class CustomerLoginDaoImpl implements CustomerLoginDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CustomerLogin createCustomerLogin(CustomerLogin customerLogin) {

		entityManager.persist(customerLogin);
		entityManager.flush();
		return customerLogin;
	}

	@Override
	public List<CustomerLogin> getAllCustomerLogins() {
		Query q = entityManager.createQuery("from CustomerLogin");
		List<CustomerLogin> list = q.getResultList();
		return list;
	}

	@Override
	public CustomerLogin findCustomerLoginById(int customerLoginId) {
		CustomerLogin customerLogin = entityManager.find(CustomerLogin.class, customerLoginId);
		return customerLogin;
	}

	@Override
	public CustomerLogin updateCustomerLogin(CustomerLogin customerLogin) {
		CustomerLogin customerLogin2 = entityManager.merge(customerLogin);
		return customerLogin2;
	}

	@Override
	public CustomerLogin findUserByUserName(String username) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		AbstractQuery<CustomerLogin> cq1 = cb.createQuery(CustomerLogin.class);
		Root<CustomerLogin> custRoot = cq1.from(CustomerLogin.class);

		cq1.where(cb.equal(custRoot.get("customerUserName"), username));

		CriteriaQuery<CustomerLogin> selectRecord = ((CriteriaQuery<CustomerLogin>) cq1).select(custRoot);
		TypedQuery<CustomerLogin> tq1 = entityManager.createQuery(selectRecord);
		CustomerLogin customerLogin = tq1.getSingleResult();

		return customerLogin;
	}

	@Override
	public CustomerLogin updatePassword(int CustomerLoginId, String newpassword) {
		CustomerLogin customerLogin=entityManager.find(CustomerLogin.class,CustomerLoginId);
		customerLogin.setCustomerPassword(newpassword);
		customerLogin=entityManager.merge(customerLogin);
		       
		        return customerLogin;
		    }
	}


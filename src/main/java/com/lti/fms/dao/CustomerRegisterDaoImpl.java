/**
 * 
 */
package com.lti.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.fms.entities.CustomerRegistration;

/**
 * @author lntinfotech/Ashika Jinturkar
 *
 */

@Repository
@Transactional
public class CustomerRegisterDaoImpl implements CustomerRegisterDao {

	@PersistenceContext
	EntityManager entityManager;

	private CustomerRegistration customerRegistration = null;

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
		CustomerRegistration customerRegistration = entityManager.find(CustomerRegistration.class, customerId);

		entityManager.remove(customerRegistration);
	}

	@Override
	public CustomerRegistration findUserByUserName(String username) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		AbstractQuery<CustomerRegistration> cq1 = cb.createQuery(CustomerRegistration.class);
		Root<CustomerRegistration> custRoot = cq1.from(CustomerRegistration.class);

		cq1.where(cb.equal(custRoot.get("username"), username));

		CriteriaQuery<CustomerRegistration> selectRecord = ((CriteriaQuery<CustomerRegistration>) cq1).select(custRoot);
		TypedQuery<CustomerRegistration> tq1 = entityManager.createQuery(selectRecord);
		CustomerRegistration customerRegistration = tq1.getSingleResult();

		return customerRegistration;
	}

	@SuppressWarnings("finally")
	@Override
	public CustomerRegistration findUserEmail(String email) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		AbstractQuery<CustomerRegistration> cq1 = cb.createQuery(CustomerRegistration.class);
		Root<CustomerRegistration> custRoot = cq1.from(CustomerRegistration.class);

		cq1.where(cb.equal(custRoot.get("email"), email));

		CriteriaQuery<CustomerRegistration> selectRecord = ((CriteriaQuery<CustomerRegistration>) cq1).select(custRoot);
		TypedQuery<CustomerRegistration> tq1 = entityManager.createQuery(selectRecord);
		try {
			customerRegistration = tq1.getSingleResult();
		}

		catch (NoResultException e) {

			System.out.println("not found");
		} finally {
			return customerRegistration;
		}

	}

}

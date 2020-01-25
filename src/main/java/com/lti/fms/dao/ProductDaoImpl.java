/**
 * 
 */
package com.lti.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.fms.entities.Products;

/**
 * @author lntinfotech
 *
 */

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Products> getAllProducts() {
		Query query = entityManager.createQuery("from Products");
		List<Products> list = query.getResultList();
		return list;
	}

	@Override
	public Products findProductById(int id) {
		Products products = entityManager.find(Products.class, id);
		return products;
	}

}

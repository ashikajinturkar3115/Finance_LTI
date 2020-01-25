/**
 * 
 */
package com.lti.fms.dao;

import java.util.List;

import com.lti.fms.entities.Products;

/**
 * @author lntinfotech
 *
 */
public interface ProductDao {

	public List<Products> getAllProducts();
	
	public Products findProductById(int id);
}

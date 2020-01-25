/**
 * 
 */
package com.lti.fms.service;

import java.util.List;

import com.lti.fms.entities.Products;

/**
 * @author lntinfotech
 *
 */
public interface ProductService {

	public List<Products> getAllProducts();
	
	public Products findProductById(int id);

	
}

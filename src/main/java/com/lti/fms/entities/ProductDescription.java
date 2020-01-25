package com.lti.fms.entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PRODUCT_DESCRIPTION")
public class ProductDescription implements Serializable {

	@Id
	@GeneratedValue
	private int productDescriptionId;
	private int productId;
	private String productDetailsDescription1;
	private String productDetailsDescription2;
	private String productDetailsDescription3;
	private String productDetailsDescription4;
	private String productDetailsDescription5;
	private float productPrice;

	@OneToOne(mappedBy = "productDescription")
	private Products products;

	/**
	 * @return the productDescriptionId
	 */
	public int getProductDescriptionId() {
		return productDescriptionId;
	}

	/**
	 * @param productDescriptionId the productDescriptionId to set
	 */
	public void setProductDescriptionId(int productDescriptionId) {
		this.productDescriptionId = productDescriptionId;
	}

	/**
	 * @return the productDetailsDescription1
	 */
	public String getProductDetailsDescription1() {
		return productDetailsDescription1;
	}

	/**
	 * @param productDetailsDescription1 the productDetailsDescription1 to set
	 */
	public void setProductDetailsDescription1(String productDetailsDescription1) {
		this.productDetailsDescription1 = productDetailsDescription1;
	}

	/**
	 * @return the productDetailsDescription2
	 */
	public String getProductDetailsDescription2() {
		return productDetailsDescription2;
	}

	/**
	 * @param productDetailsDescription2 the productDetailsDescription2 to set
	 */
	public void setProductDetailsDescription2(String productDetailsDescription2) {
		this.productDetailsDescription2 = productDetailsDescription2;
	}

	/**
	 * @return the productDetailsDescription3
	 */
	public String getProductDetailsDescription3() {
		return productDetailsDescription3;
	}

	/**
	 * @param productDetailsDescription3 the productDetailsDescription3 to set
	 */
	public void setProductDetailsDescription3(String productDetailsDescription3) {
		this.productDetailsDescription3 = productDetailsDescription3;
	}

	/**
	 * @return the productDetailsDescription4
	 */
	public String getProductDetailsDescription4() {
		return productDetailsDescription4;
	}

	/**
	 * @param productDetailsDescription4 the productDetailsDescription4 to set
	 */
	public void setProductDetailsDescription4(String productDetailsDescription4) {
		this.productDetailsDescription4 = productDetailsDescription4;
	}

	/**
	 * @return the productDetailsDescription5
	 */
	public String getProductDetailsDescription5() {
		return productDetailsDescription5;
	}

	/**
	 * @param productDetailsDescription5 the productDetailsDescription5 to set
	 */
	public void setProductDetailsDescription5(String productDetailsDescription5) {
		this.productDetailsDescription5 = productDetailsDescription5;
	}

	/**
	 * @return the products
	 */
	public Products getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Products products) {
		this.products = products;
	}

	/**
	 * @return the productPrice
	 */
	public float getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

}

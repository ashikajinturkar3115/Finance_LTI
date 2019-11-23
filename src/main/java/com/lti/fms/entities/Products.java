package com.lti.fms.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PRODUCTS")
public class Products implements Serializable {

	@Id
	@GeneratedValue
	private int productID;
	private String productName;
	private String productType;
	private int productPrice;
	private int productDescriptionId;
	
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductPurchased> productPurchased = new ArrayList<ProductPurchased>();

	
	@OneToOne(mappedBy = "products")
	private ProductDescription productDescription; 
	
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductDescriptionId() {
		return productDescriptionId;
	}

	public void setProductDescriptionId(int productDescriptionId) {
		this.productDescriptionId = productDescriptionId;
	}

	/**
	 * @return the productPurchased
	 */
	public List<ProductPurchased> getProductPurchased() {
		return productPurchased;
	}

	/**
	 * @param productPurchased the productPurchased to set
	 */
	public void setProductPurchased(List<ProductPurchased> productPurchased) {
		this.productPurchased = productPurchased;
	}

	/**
	 * @return the productDescription
	 */
	public ProductDescription getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(ProductDescription productDescription) {
		this.productDescription = productDescription;
	}

	
	
	
	

}

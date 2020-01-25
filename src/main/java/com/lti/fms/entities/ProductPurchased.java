package com.lti.fms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author lntinfotech/SurajNishad
 *
 */
@Entity
@Table(name = "TBL_PRODUCT_PURCHASED")
public class ProductPurchased {

	@Id
	@GeneratedValue
	private int productPurchasedId;

	private int productId;
	private int userId;
	private int itemPurchasedPrice;
	private String purchaseDate;
	private String emiCardNo;
	private String emiType;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "productID") private Products products;
	 */

	@ManyToOne
	@JoinColumn(name = "emiCardId")
	private EMICard emiCard;

	public int getProductPurchasedId() {
		return productPurchasedId;
	}

	public void setProductPurchasedId(int productPurchasedId) {
		this.productPurchasedId = productPurchasedId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getItemPurchasedPrice() {
		return itemPurchasedPrice;
	}

	public void setItemPurchasedPrice(int itemPurchasedPrice) {
		this.itemPurchasedPrice = itemPurchasedPrice;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getEmiCardNo() {
		return emiCardNo;
	}

	public void setEmiCardNo(String emiCardNo) {
		this.emiCardNo = emiCardNo;
	}

	public String getEmiType() {
		return emiType;
	}

	public void setEmiType(String emiType) {
		this.emiType = emiType;
	}

	/**
	 * @return the products
	 */
	/*
	 * public Products getProducts() { return products; }
	 * 
	 *//**
		 * @param products the products to set
		 *//*
			 * public void setProducts(Products products) { this.products = products; }
			 */

	/**
	 * @return the emiCard
	 */
	public EMICard getEmiCard() {
		return emiCard;
	}

	/**
	 * @param emiCard the emiCard to set
	 */
	public void setEmiCard(EMICard emiCard) {
		this.emiCard = emiCard;
	}

}

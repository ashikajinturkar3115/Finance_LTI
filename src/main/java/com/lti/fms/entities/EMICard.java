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

/**
 * @author lntinfotech/SurajNishad
 *
 */
@Entity
@Table(name = "TBL_EMICARD")
public class EMICard implements Serializable {

	@Id
	@GeneratedValue
	private int emiCardId;

	private String emiCardNo;

	private String cardType;
	private double totalBalance;
	private double availableBalance;

	@OneToMany(mappedBy = "emiCard", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductPurchased> productPurchased = new ArrayList<ProductPurchased>();

	@OneToOne(mappedBy = "emiCard")
	private CustomerLogin customerLogin;

	public int getEmiCardId() {
		return emiCardId;
	}

	public void setEmiCardId(int emiCardId) {
		this.emiCardId = emiCardId;
	}

	/**
	 * @return the emiCardNo
	 */
	public String getEmiCardNo() {
		return emiCardNo;
	}

	/**
	 * @param emiCardNo the emiCardNo to set
	 */
	public void setEmiCardNo(String emiCardNo) {
		this.emiCardNo = emiCardNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
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
	 * @return the customerLogin
	 */
	public CustomerLogin getCustomerLogin() {
		return customerLogin;
	}

	/**
	 * @param customerLogin the customerLogin to set
	 */
	public void setCustomerLogin(CustomerLogin customerLogin) {
		this.customerLogin = customerLogin;
	}

}

/**
 * 
 */
package com.lti.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ashika Jinturkar
 *
 */

@Entity
@Table(name = "TBL_EMI_PURCHASE_DESCRIP")
public class EMIPurchaseDescription implements Serializable {

	@Id
	@GeneratedValue
	private int emiPurchaseDescpritionId;

	private String emiCardNumber;

	private int totalAmount;

	private int monthlyAmount;

	private String deductionDate;

	/**
	 * @return the emiPurchaseDescpritionId
	 */
	public int getEmiPurchaseDescpritionId() {
		return emiPurchaseDescpritionId;
	}

	/**
	 * @param emiPurchaseDescpritionId the emiPurchaseDescpritionId to set
	 */
	public void setEmiPurchaseDescpritionId(int emiPurchaseDescpritionId) {
		this.emiPurchaseDescpritionId = emiPurchaseDescpritionId;
	}

	

	public String getEmiCardNumber() {
		return emiCardNumber;
	}

	public void setEmiCardNumber(String emiCardNumber) {
		this.emiCardNumber = emiCardNumber;
	}

	/**
	 * @return the totalAmount
	 */
	public int getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the monthlyAmount
	 */
	public int getMonthlyAmount() {
		return monthlyAmount;
	}

	/**
	 * @param monthlyAmount the monthlyAmount to set
	 */
	public void setMonthlyAmount(int monthlyAmount) {
		this.monthlyAmount = monthlyAmount;
	}

	/**
	 * @return the deductionDate
	 */
	public String getDeductionDate() {
		return deductionDate;
	}

	/**
	 * @param deductionDate the deductionDate to set
	 */
	public void setDeductionDate(String deductionDate) {
		this.deductionDate = deductionDate;
	}

}

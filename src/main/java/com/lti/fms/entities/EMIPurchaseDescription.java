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

	private String EMICardNumber;

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

	/**
	 * @return the eMICardNumber
	 */
	public String getEMICardNumber() {
		return EMICardNumber;
	}

	/**
	 * @param eMICardNumber the eMICardNumber to set
	 */
	public void setEMICardNumber(String eMICardNumber) {
		EMICardNumber = eMICardNumber;
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

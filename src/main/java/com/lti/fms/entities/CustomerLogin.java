package com.lti.fms.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "TBL_CUSTOMER_LOGIN")
public class CustomerLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int customerLoginId;

	private String customerUserName;

	private String customerPassword;
	

	private String customerStatus;

	private String emiCardNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emiCardId")
	private EMICard emiCard;

	/**
	 * @return the customerLoginId
	 */
	public int getCustomerLoginId() {
		return customerLoginId;
	}

	/**
	 * @param customerLoginId the customerLoginId to set
	 */
	public void setCustomerLoginId(int customerLoginId) {
		this.customerLoginId = customerLoginId;
	}

	/**
	 * @return the customerUserName
	 */
	public String getCustomerUserName() {
		return customerUserName;
	}

	/**
	 * @param customerUserName the customerUserName to set
	 */
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	/**
	 * @return the customerPassword
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}

	/**
	 * @param customerPassword the customerPassword to set
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	/**
	 * @return the customerStatus
	 */
	public String getCustomerStatus() {
		return customerStatus;
	}

	/**
	 * @param customerStatus the customerStatus to set
	 */
	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

/**
 * 
 */
package com.lti.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Ashika Jinturkar
 *
 */
@Entity
@Table(name = "TBL_CUSTOMER_REGISTRATION")
public class CustomerRegistration implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq1")
	@SequenceGenerator(name = "seq1", sequenceName = "TBL_CUST_REGISTRATION_SEQ", initialValue = 1, allocationSize = 1)
	private int customerId;
	private int customerLoginId;
	private String name;
	private String contact;
	private String email;
	private String bankName;
	private String accountNo;
	private String ifsc;
	private String address;
	private String username;
	private String password;
	private String confirmPassword;
	private String cardType;

	private String filePathAdhar;
	private String fileNameAdhar;
	private String contentTypeAdhar;

	private String filePathCheque;
	private String fileNameCheque;
	private String contentTypeCheque;

	private String filePathPAN;
	private String fileNamePAN;
	private String contentTypePAN;

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the ifsc
	 */
	public String getIfsc() {
		return ifsc;
	}

	/**
	 * @param ifsc the ifsc to set
	 */
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @return the filePathAdhar
	 */
	public String getFilePathAdhar() {
		return filePathAdhar;
	}

	/**
	 * @param filePathAdhar the filePathAdhar to set
	 */
	public void setFilePathAdhar(String filePathAdhar) {
		this.filePathAdhar = filePathAdhar;
	}

	/**
	 * @return the fileNameAdhar
	 */
	public String getFileNameAdhar() {
		return fileNameAdhar;
	}

	/**
	 * @param fileNameAdhar the fileNameAdhar to set
	 */
	public void setFileNameAdhar(String fileNameAdhar) {
		this.fileNameAdhar = fileNameAdhar;
	}

	/**
	 * @return the contentTypeAdhar
	 */
	public String getContentTypeAdhar() {
		return contentTypeAdhar;
	}

	/**
	 * @param contentTypeAdhar the contentTypeAdhar to set
	 */
	public void setContentTypeAdhar(String contentTypeAdhar) {
		this.contentTypeAdhar = contentTypeAdhar;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the filePathCheque
	 */
	public String getFilePathCheque() {
		return filePathCheque;
	}

	/**
	 * @param filePathCheque the filePathCheque to set
	 */
	public void setFilePathCheque(String filePathCheque) {
		this.filePathCheque = filePathCheque;
	}

	/**
	 * @return the fileNameCheque
	 */
	public String getFileNameCheque() {
		return fileNameCheque;
	}

	/**
	 * @param fileNameCheque the fileNameCheque to set
	 */
	public void setFileNameCheque(String fileNameCheque) {
		this.fileNameCheque = fileNameCheque;
	}

	/**
	 * @return the contentTypeCheque
	 */
	public String getContentTypeCheque() {
		return contentTypeCheque;
	}

	/**
	 * @param contentTypeCheque the contentTypeCheque to set
	 */
	public void setContentTypeCheque(String contentTypeCheque) {
		this.contentTypeCheque = contentTypeCheque;
	}

	/**
	 * @return the filePathPAN
	 */
	public String getFilePathPAN() {
		return filePathPAN;
	}

	/**
	 * @param filePathPAN the filePathPAN to set
	 */
	public void setFilePathPAN(String filePathPAN) {
		this.filePathPAN = filePathPAN;
	}

	/**
	 * @return the fileNamePAN
	 */
	public String getFileNamePAN() {
		return fileNamePAN;
	}

	/**
	 * @param fileNamePAN the fileNamePAN to set
	 */
	public void setFileNamePAN(String fileNamePAN) {
		this.fileNamePAN = fileNamePAN;
	}

	/**
	 * @return the contentTypePAN
	 */
	public String getContentTypePAN() {
		return contentTypePAN;
	}

	/**
	 * @param contentTypePAN the contentTypePAN to set
	 */
	public void setContentTypePAN(String contentTypePAN) {
		this.contentTypePAN = contentTypePAN;
	}

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

}

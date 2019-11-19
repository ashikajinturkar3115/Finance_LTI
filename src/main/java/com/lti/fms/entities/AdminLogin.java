package com.lti.fms.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "TBL_ADMIN_LOGIN")
public class AdminLogin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer adminID;

	private String adminName;

	private String adminPassword;

	/**
	 * @return the adminID
	 */
	public Integer getAdminID() {
		return adminID;
	}

	/**
	 * @param adminID the adminID to set
	 */
	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}

	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * @return the adminPassword
	 */
	public String getAdminPassword() {
		return adminPassword;
	}

	/**
	 * @param adminPassword the adminPassword to set
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

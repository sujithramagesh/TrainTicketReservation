package com.suji.train.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int uId;
	private  String uName;
	private String password;
	private String emailId;
	private long phoneNumber;
	private long creationDate;

	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(creationDate, emailId, password, phoneNumber, uId, uName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(creationDate, other.creationDate) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(password, other.password) && phoneNumber == other.phoneNumber && uId == other.uId
				&& Objects.equals(uName, other.uName);
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", password=" + password + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", creationDate=" + creationDate + "]";
	}

}

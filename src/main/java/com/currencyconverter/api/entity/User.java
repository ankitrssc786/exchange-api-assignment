package com.currencyconverter.api.entity;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String userId;

	private String princingTier;

	private String emailAddress;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPrincingTier() {
		return princingTier;
	}

	public void setPrincingTier(String princingTier) {
		this.princingTier = princingTier;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", princingTier=" + princingTier + ", emailAddress=" + emailAddress + "]";
	}

}

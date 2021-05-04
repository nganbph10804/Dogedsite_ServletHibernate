package com.ass.admin.domain;

import java.util.Date;

public class FavoriteUserReport {
	private String username;
	private String fullName;
	private String email;
	private Date likeDate;
	public String getusername() {
		return username;
	}
	
	public FavoriteUserReport() {
		
	}

	public FavoriteUserReport(String username, String fullName, String email, Date likeDate) {
		
		this.username = username;
		this.fullName = fullName;
		this.email = email;
		this.likeDate = likeDate;
	}

	public void setusername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
	
	
}

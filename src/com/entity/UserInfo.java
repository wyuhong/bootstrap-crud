package com.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = 438471543499513882L;
	
	private int userId;
	private String userName;
	private String userPwd;
	public UserInfo() {}
	public UserInfo(String userName, String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	

}

package com.stackroute.keepnote.model;

import java.util.Date;

/*
 * The class "User" will be acting as the data model for the User Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */

public class User {

	/*
	 * This class should have five fields (userId,userName,
	 * userPassword,userMobile,userAddedDate). Out of these five fields, the field
	 * userId should be the primary key. This class should also contain the getters
	 * and setters for the fields, along with the no-arg , parameterized constructor
	 * and toString method.The value of userAddedDate should not be accepted from
	 * the user but should be always initialized with the system date
	 */
	private int userId;
	private String userName;
	private String userPassword;
	private String userMobile;
	private Date userAddedDate;
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
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public Date getUserAddedDate() {
		return userAddedDate;
	}
	public void setUserAddedDate(Date userAddedDate) {
		this.userAddedDate = userAddedDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userMobile="
				+ userMobile + ", userAddedDate=" + userAddedDate + "]";
	}
	public User(int userId, String userName, String userPassword, String userMobile, Date userAddedDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMobile = userMobile;
		this.userAddedDate = userAddedDate;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public User() {
//
//	}
//
//	public User(String string, String string1, String string2, String string3, Date date) {
//
//	}
//
//	public String getUserId() {
//		return null;
//	}
//
//	public void setUserId(String string) {
//
//	}
//
//	public void setUserName(String string) {
//
//	}
//
//	public String getUserPassword() {
//		return null;
//
//	}
//
//	public void setUserPassword(String string) {
//
//	}
//
//	public String getUserMobile() {
//		return null;
//
//	}
//
//	public void setUserMobile(String string) {
//
//	}
//
//	public void setUserAddedDate(Date date) {
//
//	}

}

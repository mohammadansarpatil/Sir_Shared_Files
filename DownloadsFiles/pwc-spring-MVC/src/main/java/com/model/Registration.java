package com.model;

public class Registration {
	
	private String userName;
	private String password;
	private String email;
	private String city;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Registration [userName=" + userName + ", password=" + password + ", email=" + email + ", city=" + city
				+ "]";
	}
	public Registration(String userName, String password, String email, String city) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.city = city;
	}
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

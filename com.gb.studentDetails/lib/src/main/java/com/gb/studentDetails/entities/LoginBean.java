package com.gb.studentDetails.entities;

import javax.validation.constraints.NotEmpty;

public class LoginBean {

	@NotEmpty(message="Username cannot be Blank")
	private String username;
	@NotEmpty(message="Password cannot be Blank")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	
	}
	public LoginBean() {
	}
}

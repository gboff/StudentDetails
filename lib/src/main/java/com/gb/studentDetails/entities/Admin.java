package com.gb.studentDetails.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	
	@NotEmpty(message="Username cannot be Blank")
	private String username;
	@NotEmpty(message="Password cannot be Blank")
	private String password;
	
	@NumberFormat
	@Size(min = 10, max= 10)
	@NotEmpty(message="mobile number must be provided")
	private String mobileNumber;
	
	@Email
	@NotEmpty(message="email must be provided")
	private String email;
	
	
	public int getAdminId() {
		return adminId;
	}
//	public void setAdminId(int adminId) {
//		this.adminId = adminId;
//	}
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Admin() {
		super();
	}
	public Admin(int adminId, String username, String password, String mobileNumber, String email) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + ", mobileNumber="
				+ mobileNumber + ", email=" + email + "]";
	}
	
}

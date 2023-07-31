package com.gb.studentDetails.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

@Entity 
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	private String name;
	
	@NumberFormat
	@Size(min = 10, max= 10)
	@NotEmpty(message="mobile number must be provided")
	private String mobileNumber;
	
	private String className;
	
	private String rollNumber;
	
	private String dob;
	
	@NumberFormat
	@Size(min = 12, max= 12)
	private String aadhar;
	
	private String address;
	
	private String bloodGroup;
	
	private String emis;
	
	private String fatherName;
	
	private String motherName;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getClassName() {
		return className;
	}
	
	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getEmis() {
		return emis;
	}

	public void setEmis(String emis) {
		this.emis = emis;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public int getStudentId() {
		return studentId;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", className="
				+ className + ", rollNumber=" + rollNumber + ", dob=" + dob + ", aadhar=" + aadhar + ", address=" + address + ", bloodGroup="
				+ bloodGroup + ", emis=" + emis + ", fatherName=" + fatherName + ", motherName=" + motherName + "]";
	}

	public Student(int studentId, String name,String mobileNumber,
			String className,String rollNumber, String dob, String aadhar, String address, String bloodGroup, String emis,
			String fatherName, String motherName) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.className = className;
		this.rollNumber = rollNumber;
		this.dob = dob;
		this.aadhar = aadhar;
		this.address = address;
		this.bloodGroup = bloodGroup;
		this.emis = emis;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}
	
	public Student() {}




	
	
	
	
}

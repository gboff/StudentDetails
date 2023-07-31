package com.gb.studentDetails.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class FeesDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feesId;
	
	private LocalDateTime LogDate;
	
	private int studentId;
	
	private String studentName;
	
	private String studentClass;
	
	private String studentRollNumber;
	
	private int oldBalance;
	
	private int term1Balance;
	private int term2Balance;
	private int term3Balance;
	
	private int currentBalance;
	
	private int totalBalance;

	public LocalDateTime getLogDate() {
		return LogDate;
	}

	public void setLogDate(LocalDateTime logDate) {
		LogDate = logDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public int getOldBalance() {
		return oldBalance;
	}

	public void setOldBalance(int oldBalance) {
		this.oldBalance = oldBalance;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(int totalBalance) {
		this.totalBalance = totalBalance;
	}

	public int getFeesId() {
		return feesId;
	}
	
	

	public String getStudentRollNumber() {
		return studentRollNumber;
	}

	public void setStudentRollNumber(String studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}
	
	

	public int getTerm1Balance() {
		return term1Balance;
	}

	public void setTerm1Balance(int term1Balance) {
		this.term1Balance = term1Balance;
	}

	public int getTerm2Balance() {
		return term2Balance;
	}

	public void setTerm2Balance(int term2Balance) {
		this.term2Balance = term2Balance;
	}

	public int getTerm3Balance() {
		return term3Balance;
	}

	public void setTerm3Balance(int term3Balance) {
		this.term3Balance = term3Balance;
	}

	public FeesDetails(int feesId, LocalDateTime logDate, int studentId, String studentName, String studentClass, String studentRollNumber,
			int oldBalance,int term1Balance,int term2Balance,int term3Balance, int currentBalance, int totalBalance) {
		super();
		this.feesId = feesId;
		LogDate = logDate;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.studentRollNumber = studentRollNumber;
		this.oldBalance = oldBalance;
		this.term1Balance = term1Balance;
		this.term2Balance = term2Balance;
		this.term3Balance = term3Balance;
		this.currentBalance = currentBalance;
		this.totalBalance = totalBalance;
	}

	public FeesDetails() {
		super();
	}

	@Override
	public String toString() {
		return "FeesDetails [feesId=" + feesId + ", LogDate=" + LogDate + ", studentId=" + studentId + ", studentName="
				+ studentName + ", studentClass=" + studentClass + ", studentRollNumber=" + studentRollNumber
				+ ", oldBalance=" + oldBalance + ", term1Balance=" + term1Balance + ", term2Balance=" + term2Balance
				+ ", term3Balance=" + term3Balance + ", currentBalance=" + currentBalance + ", totalBalance="
				+ totalBalance + "]";
	}




	
	
	
}

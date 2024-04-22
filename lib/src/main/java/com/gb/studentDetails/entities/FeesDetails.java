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
	
	private Integer oldBalance;
	
	private Integer term1Balance;
	private Integer term2Balance;
	private Integer term3Balance;
	
	private Integer currentBalance;
	
	private Integer totalBalance;

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

	public Integer getOldBalance() {
		return oldBalance;
	}

	public void setOldBalance(Integer oldBalance) {
		this.oldBalance = oldBalance;
	}

	public Integer getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Integer currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Integer getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Integer totalBalance) {
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
	
	

	public Integer getTerm1Balance() {
		return term1Balance;
	}

	public void setTerm1Balance(Integer term1Balance) {
		this.term1Balance = term1Balance;
	}

	public Integer getTerm2Balance() {
		return term2Balance;
	}

	public void setTerm2Balance(Integer term2Balance) {
		this.term2Balance = term2Balance;
	}

	public Integer getTerm3Balance() {
		return term3Balance;
	}

	public void setTerm3Balance(Integer term3Balance) {
		this.term3Balance = term3Balance;
	}

	public FeesDetails(int feesId, LocalDateTime logDate, int studentId, String studentName, String studentClass, String studentRollNumber,
			Integer oldBalance,Integer term1Balance,Integer term2Balance,Integer term3Balance, Integer currentBalance, Integer totalBalance) {
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

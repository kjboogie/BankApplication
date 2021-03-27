package com.bezkoder.springjwt.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class HomeLoan{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accountNumber;
    private String applicantName;
    private String propertyAddress;
    private String loanPeriod;
    private String loanAmount;
    private String propertyType;

    HomeLoan(){}

	public HomeLoan(String accountNumber, String applicantName, String propertyAddress, String loanPeriod,
			String loanAmount, String propertyType) {
		super();
		this.accountNumber = accountNumber;
		this.applicantName = applicantName;
		this.propertyAddress = propertyAddress;
		this.loanPeriod = loanPeriod;
		this.loanAmount = loanAmount;
		this.propertyType = propertyType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(String loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public long getId() {
		return id;
	}
    
   

}

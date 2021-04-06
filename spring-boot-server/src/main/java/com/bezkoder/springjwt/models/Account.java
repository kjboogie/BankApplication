package com.bezkoder.springjwt.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(	name = "accounts", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "accountnumber"),
			@UniqueConstraint(columnNames = "cardnumber")
})
public class Account {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	
	
	private long accountnumber;
	
	
	private int pin;
	
	@NotBlank
	private String name;
	
	private Long balance;
	
	private String accounttype; 
	
	private Long cardnumber; 
	
	@OneToMany(targetEntity = DebitOrder.class,cascade = CascadeType.ALL)
	private List<DebitOrder> debitorder;
	
	@OneToMany(targetEntity = Creditcard.class,cascade = CascadeType.ALL)
	private List<Creditcard> creditcard;
	
	@OneToMany(targetEntity = InsurancePolicy.class,cascade = CascadeType.ALL)
	private List<InsurancePolicy> ipolicy;
	
	
	
	
	public List<InsurancePolicy> getIpolicy() {
		return ipolicy;
	}



	public void setIpolicy(List<InsurancePolicy> ipolicy) {
		this.ipolicy = ipolicy;
	}



	public List<Creditcard> getCreditcard() {
		return creditcard;
	}



	public void setCreditcard(List<Creditcard> creditcard) {
		this.creditcard = creditcard;
	}



	public List<DebitOrder> getDebitorder() {
		return debitorder;
	}



	public void setDebitorder(List<DebitOrder> debitorder) {
		this.debitorder = debitorder;
	}



	public Account () {
		
	}

	

	public Account(long accountnumber, int pin,String name, Long balance, String accounttype,Long cardnumber) {
		super();
		this.accountnumber = accountnumber;
		this.pin = pin;
		this.name = name;
		this.balance = balance;
		this.accounttype = accounttype;
		this.cardnumber=cardnumber;
	}
	



	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAid() {
		return aid;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}



	public Long getCardnumber() {
		return cardnumber;
	}



	public void setCardnumber(Long cardnumber) {
		this.cardnumber = cardnumber;
	}
	
	
	
	
	
	

}

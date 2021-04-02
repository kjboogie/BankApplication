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


import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(	name = "WalletAccount", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "walletaccountnumber")
})
public class WalletAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int wid;
	private long walletaccountnumber;
	private int wpin;
	private String name;
	private Long wbalance;
	
	@OneToMany(targetEntity = WalletTransactions.class,cascade = CascadeType.ALL)
	private List<WalletTransactions> wtransactions;
	
	
	
	public List<WalletTransactions> getWtransactions() {
		return wtransactions;
	}

	public void setWtransactions(List<WalletTransactions> wtransactions) {
		this.wtransactions = wtransactions;
	}

	public WalletAccount() {
		
	}
	
	public WalletAccount(long walletaccountnumber, int wpin, String name, Long wbalance) {
		super();
		this.walletaccountnumber = walletaccountnumber;
		this.wpin = wpin;
		this.name = name;
		this.wbalance = wbalance;
	}
	public long getWalletaccountnumber() {
		return walletaccountnumber;
	}
	public void setWalletaccountnumber(long walletaccountnumber) {
		this.walletaccountnumber = walletaccountnumber;
	}
	public int getWpin() {
		return wpin;
	}
	public void setWpin(int wpin) {
		this.wpin = wpin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getWbalance() {
		return wbalance;
	}
	public Long setWbalance(Long wbalance) {
		
		return this.wbalance = wbalance;
	}
	public int getWid() {
		return wid;
	}
	
	
	
	
}

package com.bezkoder.springjwt.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lid;
	private String vehical;
	private String veh_num;
	private int amount;
	private String valid_till;
	
	@ManyToOne(targetEntity = Loan.class,cascade = CascadeType.ALL)
	private List<User> user; 
	
	
	
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public Loan(String vehical, String veh_num, int amount, String valid_till) {
		super();
		this.vehical = vehical;
		this.veh_num = veh_num;
		this.amount = amount;
		this.valid_till = valid_till;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getVehical() {
		return vehical;
	}
	public void setVehical(String vehical) {
		this.vehical = vehical;
	}
	public String getveh_num() {
		return veh_num;
	}
	public void setveh_num(String veh_num) {
		this.veh_num = veh_num;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getValid_till() {
		return valid_till;
	}

	public Loan (){
		
	}
	
	
}

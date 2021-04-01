package com.bezkoder.springjwt.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DebitOrder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name= "name")
    private String name;
    
    @Column(name= "fromaccountno")
    private Long fromaccountno;
    
    @Column(name= "toaccountno")
    private Long toaccountno;
    
//    @Column(name= "Date")
//    private Date date;
    
    @Column(name= "money")
    private Long money;
    
    public DebitOrder() {
    	
    }
    

	public DebitOrder(String name, Long fromaccountno, Long toaccountno, Long money) {
		super();
		this.name = name;
		this.fromaccountno = fromaccountno;
		this.toaccountno = toaccountno;
//		this.date = date;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFromaccountno() {
		return fromaccountno;
	}

	public void setFromaccountno(Long fromaccountno) {
		this.fromaccountno = fromaccountno;
	}

	public Long getToaccountno() {
		return toaccountno;
	}

	public void setToaccountno(Long toaccountno) {
		this.toaccountno = toaccountno;
	}

//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Long getId() {
		return id;
	}
    
    

 

   
}

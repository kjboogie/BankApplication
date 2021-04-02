package com.bezkoder.springjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class WalletTransactions {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
    
    @Column(name= "fromaccountno")
    private Long fromaccountno;
    
    @Column(name= "towalletaccountno")
    private Long towalletaccountno;
    
//    @Column(name= "Date")
//    private Date date;
    
    @Column(name= "money")
    private Long money;
    
    public WalletTransactions() {
    	
    }

	public WalletTransactions(Long fromaccountno, Long towalletaccountno, Long money) {
	super();
	this.fromaccountno = fromaccountno;
	this.towalletaccountno = towalletaccountno;
	this.money = money;
}

	public Long getFromaccountno() {
		return fromaccountno;
	}

	public void setFromaccountno(Long fromaccountno) {
		this.fromaccountno = fromaccountno;
	}

	public Long getTowalletaccountno() {
		return towalletaccountno;
	}

	public void setTowalletaccountno(Long towalletaccountno) {
		this.towalletaccountno = towalletaccountno;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public int getId() {
		return id;
	}
    
    
	
}

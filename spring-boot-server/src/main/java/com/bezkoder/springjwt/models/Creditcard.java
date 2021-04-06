package com.bezkoder.springjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cardcredentials")

public class Creditcard
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column(name = "Movie",nullable=false)
private String mname;
@Column(name = "Date",nullable=false)
private String date;

@Column(name = "Time",nullable=false)
private String time;

@Column(name = "Seats",nullable=false)
private String seats;


@Column(name = "Card_Holder_Name",nullable=false)
private String username;

@Column(name = "Card_Number",length=16,nullable=false,unique=true)
private Long cardnumber;

@Column(name = "Expiry_Month",length=2,nullable=false)
private String expirymonth;

@Column(name = "Expiry_Year",length=2,nullable=false)
private String expiryyear;

@Column(name = "CVV",length=3,nullable=false)
private int cvv;

@Column(name = "Dedited_Ammount",nullable=false)
private Long payammount;

public Creditcard()
{
}


public Creditcard(String mname, String date, String time, String seats, String username, Long cardnumber,
String expirymonth, String expiryyear, int cvv, Long payammount) {
super();
this.mname = mname;
this.date = date;
this.time = time;
this.seats = seats;
this.username = username;
this.cardnumber = cardnumber;
this.expirymonth = expirymonth;
this.expiryyear = expiryyear;
this.cvv = cvv;
this.payammount = payammount;
}


public long getId() {
return id;
}


public void setId(long id) {
this.id = id;
}


public String getMname() {
return mname;
}


public void setMname(String mname) {
this.mname = mname;
}


public String getDate() {
return date;
}


public void setDate(String date) {
this.date = date;
}


public String getTime() {
return time;
}


public void setTime(String time) {
this.time = time;
}


public String getSeats() {
return seats;
}


public void setSeats(String seats) {
this.seats = seats;
}


public String getUsername() {
return username;
}


public void setUsername(String username) {
this.username = username;
}


public Long getCardnumber() {
return cardnumber;
}


public void setCardnumber(Long cardnumber) {
this.cardnumber = cardnumber;
}


public String getExpirymonth() {
return expirymonth;
}


public void setExpirymonth(String expirymonth) {
this.expirymonth = expirymonth;
}


public String getExpiryyear() {
return expiryyear;
}


public void setExpiryyear(String expiryyear) {
this.expiryyear = expiryyear;
}


public int getCvv() {
return cvv;
}


public void setCvv(int cvv) {
this.cvv = cvv;
}


public Long getPayammount() {
return payammount;
}


public void setPayammount(Long payammount) {
this.payammount = payammount;
}
}



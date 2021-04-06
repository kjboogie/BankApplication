package com.bezkoder.springjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class InsurancePolicy {

 

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private int id;

 

    @Column(name = "full_name", nullable=false)
        private String fullName;

 

    @Column(name = "gender", nullable=false)
        private String gender;

 

    @Column(name = "lookingto_Insure", nullable=false)
    private String lookingtoInsure;

 

    @Column(name = "email", nullable=false)
    private String email;

 

    @Column(name = "contact_no",nullable=false)
    private long contactNo;

 

    @Column(name = "age", nullable=false)
    private int age;

 

    @Column(name = "critical_illness", nullable=false)
    private String criticalIllness;

 

    @Column(name = "policy_name", nullable=false)
    private String policyName;

 

    @Column(name = "card_num", nullable=false)
    private long cardnumber;
    
    @Column(name = "cvv_no", nullable=false)
    private int cvvNo;
    
    @Column(name = "expiry_date", nullable=false)
    private String expiryDate;
    
    @Column(name = "amt_topay", nullable=false)
    private long amtToPay;
    
    public InsurancePolicy() {}

 

    public InsurancePolicy( String fullName, String gender, String lookingtoInsure, String email, long contactNo,
            int age, String criticalIllness, String policyName, long cardnumber, int cvvNo, String expiryDate,
            long amtToPay) {
        super();
        this.fullName = fullName;
        this.gender = gender;
        this.lookingtoInsure = lookingtoInsure;
        this.email = email;
        this.contactNo = contactNo;
        this.age = age;
        this.criticalIllness = criticalIllness;
        this.policyName = policyName;
        this.cardnumber = cardnumber;
        this.cvvNo = cvvNo;
        this.expiryDate = expiryDate;
        this.amtToPay = amtToPay;
    }

 

    
    public int getId() {
        return id;
    }

 

   
 

    public String getFullName() {
        return fullName;
    }

 

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

 

    public String getGender() {
        return gender;
    }

 

    public void setGender(String gender) {
        this.gender = gender;
    }

 

    public String getLookingtoInsure() {
        return lookingtoInsure;
    }

 

    public void setLookingtoInsure(String lookingtoInsure) {
        this.lookingtoInsure = lookingtoInsure;
    }

 

    public String getEmail() {
        return email;
    }

 

    public void setEmail(String email) {
        this.email = email;
    }

 

    public long getContactNo() {
        return contactNo;
    }

 

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

 

    public int getAge() {
        return age;
    }

 

    public void setAge(int age) {
        this.age = age;
    }

 

    public String getCriticalIllness() {
        return criticalIllness;
    }

 

    public void setCriticalIllness(String criticalIllness) {
        this.criticalIllness = criticalIllness;
    }

 

    public String getPolicyName() {
        return policyName;
    }

 

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

 

    public long getCardnumber() {
        return cardnumber;
    }

 

    public void setCardnumber(long cardnumber) {
        this.cardnumber = cardnumber;
    }

 

    public int getCvvNo() {
        return cvvNo;
    }

 

    public void setCvvNo(int cvvNo) {
        this.cvvNo = cvvNo;
    }

 

    public String getExpiryDate() {
        return expiryDate;
    }

 

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

 

    public Long getAmtToPay() {
        return amtToPay;
    }

 

    public void setAmtToPay(long amtToPay) {
        this.amtToPay = amtToPay;
    }
    
    
}

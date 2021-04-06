package com.bezkoder.springjwt.security.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Account;
import com.bezkoder.springjwt.models.InsurancePolicy;
import com.bezkoder.springjwt.repository.AccountRepository;

@Service
public class InsurancePolicyService {
	
	@Autowired
	private AccountRepository accountepository;
	
	    @Transactional
	    public void addIpolicyForUser(long cardnumber, InsurancePolicy policy) {
	        Account account = accountepository.findBycardnumber(cardnumber);
	        List<InsurancePolicy> ipolicy = account.getIpolicy(); 
	        ipolicy.add(policy);
	        account.setIpolicy(ipolicy);
	        
	    }

	 

	    public List<InsurancePolicy> findAllIpolicyOfUser(long cardnumber) {    
	         Account account = accountepository.findBycardnumber(cardnumber);
	            List<InsurancePolicy> ipolicy = account.getIpolicy();
	            return ipolicy;
	        
	    }

}

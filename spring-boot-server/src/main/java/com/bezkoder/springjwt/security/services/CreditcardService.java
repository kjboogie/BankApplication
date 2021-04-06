package com.bezkoder.springjwt.security.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Account;
import com.bezkoder.springjwt.models.Creditcard;
import com.bezkoder.springjwt.repository.AccountRepository;

@Service
public class CreditcardService {
	
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional
	public void addCreditCardForAccount(Long cardnumber, Creditcard cc) {
	Account account = accountRepository.findBycardnumber(cardnumber);
	List<Creditcard> creditcard = account.getCreditcard();
	creditcard.add(cc);
	account.setCreditcard(creditcard);
	}
	// display CreditCard
	public List<Creditcard> findAllTranscations1(Long cardnumber) {
	Account account = accountRepository.findBycardnumber(cardnumber);
	List<Creditcard> creditcard = account.getCreditcard();
	return creditcard;
	}

}

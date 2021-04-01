package com.bezkoder.springjwt.security.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Account;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.AccountRepository;
import com.bezkoder.springjwt.repository.UserRepository;

@Service
public class AccountService {

	@Autowired
	private UserRepository userrepository;
	@Autowired
	private AccountRepository accountrepository;
	
	@Transactional
	public void addAccountForUser(String username, Account a) {
		User user = userrepository.findByusername(username);
		List<Account> account = user.getAccount();
		account.add(a);
		user.setAccount(account);
	}

	public List<Account> findAccountOfAUser(String username) {

		User user = userrepository.findByusername(username);
		List<Account> account = user.getAccount();
		return account;
	}
	
	
	
}

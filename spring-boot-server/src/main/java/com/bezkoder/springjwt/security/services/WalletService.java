package com.bezkoder.springjwt.security.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Account;
import com.bezkoder.springjwt.models.DebitOrder;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.WalletAccount;
import com.bezkoder.springjwt.models.WalletTransactions;
import com.bezkoder.springjwt.repository.AccountRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.repository.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private UserRepository userrepository;
	@Autowired
	private AccountRepository accountrepository;
	@Autowired
	private WalletRepository wrepo;
	
	@Transactional
	public void addWalletForUser(String username, WalletAccount wa) {
		User user = userrepository.findByusername(username);
		List<WalletAccount> waccount = user.getWaccount();
		Long x = (long) 0;
		wa.setWbalance(x);
		waccount.add(wa);
		user.setWaccount(waccount);
	}
	

	public List<WalletAccount> findWalletOfAUser(String username) {
		User user = userrepository.findByusername(username);
		List<WalletAccount> waccount = user.getWaccount();
		return waccount;
	}
	
	 @Transactional
	   public void addTranscationOfWallet(Long fromaccountno,Long towalletaccountno, WalletTransactions wt) {
		 Account account = accountrepository.findByaccountnumber(fromaccountno);
		   WalletAccount acc = wrepo.findBywalletaccountnumber(towalletaccountno);
		   //add or update balance in wallet table
		   int wid = wrepo.findIdByaccountnumber(towalletaccountno);
		   int wbal = wrepo.findbalanceById(wid);
		   WalletAccount waccount = wrepo.getOne(wid);
		   Long updateWalletBalance = wbal + wt.getMoney();
		   waccount.setWbalance(updateWalletBalance);
		   //User account's balance updations(subtract from savings/current account)
		   int  accid = accountrepository.findIdByaccountnumber(fromaccountno);	
		   int senbal = accountrepository.findbalanceById(accid);
		   Account acctest2 = accountrepository.getOne(accid);
		   Long newsenbal = senbal - wt.getMoney();
		   acctest2.setBalance(newsenbal);
		   
		   List<WalletTransactions> wtransaction = acc.getWtransactions();
		   wtransaction.add(wt);
		   acc.setWtransactions(wtransaction);
		      
	 }
	
}

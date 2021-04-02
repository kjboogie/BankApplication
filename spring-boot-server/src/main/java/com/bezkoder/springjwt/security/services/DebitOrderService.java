package com.bezkoder.springjwt.security.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Account;
import com.bezkoder.springjwt.models.DebitOrder;
import com.bezkoder.springjwt.models.Loan;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.AccountRepository;
import com.bezkoder.springjwt.repository.UserRepository;

@Service
public class DebitOrderService{
	
	@Autowired
	private AccountRepository accountrepository;
	@Autowired
	private UserRepository userrepository;
	
   @Transactional
   public void addDebitOrderForAccount(Long recaccnumber,Long senaccnumber, DebitOrder db) {
		Account account = accountrepository.findByaccountnumber(recaccnumber);
		   Account acc = accountrepository.findByaccountnumber(senaccnumber);
		   //add or update balance in account table
		   int  recid = accountrepository.findIdByaccountnumber(recaccnumber);	
		   int recbal = accountrepository.findbalanceById(recid);
		   Account acctest = accountrepository.getOne(recid);
		   Long newrecbal = recbal+ db.getMoney();
		   acctest.setBalance(newrecbal);
		   //subtract balance from senders account
		   int  accid = accountrepository.findIdByaccountnumber(senaccnumber);	
		   int senbal = accountrepository.findbalanceById(accid);
		   Account acctest2 = accountrepository.getOne(accid);
		   Long newsenbal = senbal - db.getMoney();
		   acctest2.setBalance(newsenbal);
		   
		   List<DebitOrder> dbdborder = account.getDebitorder();
		   dbdborder.add(db);
		   account.setDebitorder(dbdborder);
   }
	
	
	// display debitorder
	public List<DebitOrder> findAllTranscations(Long accnumber) {
		Account account = accountrepository.findByaccountnumber(accnumber);
//		User user = userrepository.findByusername(username);
		List<DebitOrder> dborder = account.getDebitorder();
		return dborder;
	}
	
//	//sender account filter
//	public List<DebitOrder> findSendTranscations(Long sendaccnumber) {
//		Account account = accountrepository.findByaccountnumber(sendaccnumber);
//		List<DebitOrder> dborder = account.getDebitorder();
//		return dborder;
//	}
	
	
	
}

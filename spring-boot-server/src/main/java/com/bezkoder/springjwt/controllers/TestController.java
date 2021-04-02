package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Account;
import com.bezkoder.springjwt.models.DebitOrder;
import com.bezkoder.springjwt.models.HomeLoan;
import com.bezkoder.springjwt.models.Loan;
import com.bezkoder.springjwt.models.WalletAccount;
import com.bezkoder.springjwt.models.WalletTransactions;
import com.bezkoder.springjwt.repository.HomeLoanRepository;
import com.bezkoder.springjwt.security.services.AccountService;
import com.bezkoder.springjwt.security.services.DebitOrderService;
import com.bezkoder.springjwt.security.services.LoanService;
import com.bezkoder.springjwt.security.services.WalletService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	 private LoanService loanservice;
	@Autowired
	private HomeLoanRepository homeloanrepository;
	@Autowired
	private AccountService accountservice;
	@Autowired
	private DebitOrderService dbsoervice;
	@Autowired
	private WalletService wservice;
	
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

//	@GetMapping("/mod")
//	@PreAuthorize("hasRole('MODERATOR')")
//	public String moderatorAccess() {
//		return "Moderator Board.";
//	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
		//Vehical loan 
	
		 @PutMapping("/{username}/loan")
		 @CrossOrigin(origins = "http://localhost:4200")
		 @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		 public ResponseEntity<Void> addLoanForUser(@PathVariable("username") String username ,@RequestBody Loan loan ){
			 loanservice.addLoanForUser(username, loan);
			 ResponseEntity<Void> re = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			 return re;
		 }
		
		 //Get Vehical Loan
		 @GetMapping("/user/{username}/loan")
		 @CrossOrigin(origins = "http://localhost:4200")
		 @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		 public List<Loan> findLoanOfAUser(@PathVariable("username") String username) {
			 return loanservice.findLoanOfAUser(username);
		 }
	
		 
		 // Home Loan
		     @PutMapping("/addhomeloan/{username}")
		     @CrossOrigin(origins = "http://localhost:4200")
			 @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		     public ResponseEntity<Void> addHomeLoan(@PathVariable("username") String username, @RequestBody HomeLoan hloan){
		    	 loanservice.addHloanForUser(username, hloan);
		    	 ResponseEntity<Void> re = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
				 return re;
		         
		    }
		  
		  //Display Home Loan
		    @GetMapping("/gethomeloans/{username}/hloan")
		    @CrossOrigin(origins = "http://localhost:4200")
			 @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		    public List<HomeLoan> getloans(@PathVariable("username") String username){
		        return loanservice.findAllHlonOfUser(username);
		    }
		    
		    //Insert Account related to user
		    @PutMapping("/addaccount/{username}/account")
		    @CrossOrigin(origins = "http://localhost:4200")
			@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		    public ResponseEntity<Void> addAccountForUser(@PathVariable("username") String username, @RequestBody Account account){
		    	accountservice.addAccountForUser(username,account);
		    	 ResponseEntity<Void> re = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
				 return re;
		    }
		    
		    @GetMapping("/account/{username}")
		    @CrossOrigin(origins = "http://localhost:4200")
		    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		    public List<Account> findAccountOfAUser(@PathVariable("username") String username){
		    	return accountservice.findAccountOfAUser(username);
		    }
		    
		    //DebitOrder Insert
		    @PutMapping("/{recaccnumber}/debitorder/{senaccnumber}")
		    @CrossOrigin(origins = "http://localhost:4200")
			@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		    public ResponseEntity<Void> debitorderToSpecificAccount(@PathVariable("recaccnumber") Long recaccnumber,@PathVariable("senaccnumber") Long senaccnumber,@RequestBody DebitOrder debitorder){
		    	dbsoervice.addDebitOrderForAccount(recaccnumber,senaccnumber, debitorder);
		    	 ResponseEntity<Void> re = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
				 return re;
		    }
		    
		    //display all debitorder transcations
		    @GetMapping("/display/{accnumber}/debitorder")
		    @CrossOrigin(origins = "http://localhost:4200")
		    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		    public List<DebitOrder> findRecievedTranscations(@PathVariable("accnumber") Long accnumber){
		    	return dbsoervice.findAllTranscations(accnumber);
		    }
		    
		    //Create Wallet of User
		    @PutMapping("/addwallet/{username}/account")
		    @CrossOrigin(origins = "http://localhost:4200")
			@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		    public ResponseEntity<Void> addWalletForUser(@PathVariable("username") String username, @RequestBody WalletAccount waccount){
		    	wservice.addWalletForUser(username, waccount);
		    	 ResponseEntity<Void> re = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
				 return re;
		    }
		    
		    //Display Wallet Data
		    @GetMapping("/walletaccount/{username}")
		    @CrossOrigin(origins = "http://localhost:4200")
		    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		    public List<WalletAccount> findWalletAccountOfAUser(@PathVariable("username") String username){
		    	return wservice.findWalletOfAUser(username);
		    }
		    
		    

		    //Wallet Transaction insert
		    @PutMapping("/{fromaccountno}/walletaccount/{towalletaccountno}")
		    @CrossOrigin(origins = "http://localhost:4200")
			@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		    public ResponseEntity<Void> insertWalletTransaction(@PathVariable("fromaccountno") Long fromaccountno,@PathVariable("towalletaccountno") Long towalletaccountno,@RequestBody WalletTransactions wallettransactions){
		    	wservice.addTranscationOfWallet(fromaccountno, towalletaccountno, wallettransactions);
		    	 ResponseEntity<Void> re = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
				 return re;
		    } 
		    
		    
		    
//		    @GetMapping("/display/{sendaccnumber}/debitorder")
//		    @CrossOrigin(origins = "http://localhost:4200")
//		    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
//		    public List<DebitOrder> findAllTranscations(@PathVariable("sendaccnumber") Long sendaccnumber){
//		    	return dbsoervice.findSendTranscations(sendaccnumber);
//		    }
//		    
		    
		    
		    
		    
		    
//		    //Insert Wallet Data
//		    @PutMapping("/wallet/{username}")
//		    @CrossOrigin(origins = "http://localhost:4200")
//			@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
//		    public ResponseEntity<Void> addWalletForUser(@PathVariable("username") String username,@RequestBody Wallet wallet)
//		    {
//		    	walletservice.addDataInWalletForUser(username,wallet);
//		    	 ResponseEntity<Void> re = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
//				 return re;
//		    }
		    
	
}

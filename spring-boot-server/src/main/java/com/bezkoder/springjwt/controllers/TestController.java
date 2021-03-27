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

import com.bezkoder.springjwt.models.HomeLoan;
import com.bezkoder.springjwt.models.Loan;

import com.bezkoder.springjwt.repository.HomeLoanRepository;
import com.bezkoder.springjwt.security.services.LoanService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	 private LoanService loanservice;
	@Autowired
	private HomeLoanRepository homeloanrepository;
	
	
	
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

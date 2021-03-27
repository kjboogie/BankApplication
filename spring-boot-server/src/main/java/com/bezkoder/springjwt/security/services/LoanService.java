package com.bezkoder.springjwt.security.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.HomeLoan;
import com.bezkoder.springjwt.models.Loan;
import com.bezkoder.springjwt.models.User;

import com.bezkoder.springjwt.repository.UserRepository;


@Service
public class LoanService {

	@Autowired
	private UserRepository userrepository;
	
	@Transactional
	public void addLoanForUser(String username,Loan u) {
		User user = userrepository.findByusername(username);
		List<Loan> loan = user.getLoan();
		loan.add(u);
		user.setLoan(loan);	
	}

	@Transactional
	public void addHloanForUser(String username, HomeLoan hl) {
		User user = userrepository.findByusername(username);
		List<HomeLoan> hloan = user.getHloan();
		hloan.add(hl);
		user.setHloan(hloan);
		
	}
	
	

	public List<Loan> findLoanOfAUser(String username) {
		User user = userrepository.findByusername(username);
		List<Loan> loan = user.getLoan();
		return loan;
	}

	public List<HomeLoan> findAllHlonOfUser(String username) {
		User user = userrepository.findByusername(username);
		List<HomeLoan> hloan = user.getHloan();
		return hloan;
		
	}
	
	
}

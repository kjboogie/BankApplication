package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	
	public Account findByaccountnumber(Long accountnumber);
	
//	public Account findAllByaccountnumber(Long accountnumber);
}

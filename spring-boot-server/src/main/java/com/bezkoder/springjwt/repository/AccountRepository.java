package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	
	public Account findByaccountnumber(Long accountnumber);

//	public Account findIdByaccountnumber(Long senaccnumber);
	
	@Query("SELECT r.id FROM Account r where r.accountnumber = :accountnumber")
	int findIdByaccountnumber(@Param("accountnumber") Long accountnumber);
	
	@Query("SELECT r.balance FROM Account r where r.id = :id")
	int findbalanceById(int id);
	
//	public Account findAllByaccountnumber(Long accountnumber);
}

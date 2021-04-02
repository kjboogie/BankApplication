package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bezkoder.springjwt.models.Account;
import com.bezkoder.springjwt.models.WalletAccount;
import com.bezkoder.springjwt.models.WalletTransactions;

public interface WalletRepository  extends JpaRepository<WalletAccount, Integer>{

	public WalletAccount findBywalletaccountnumber(Long walletaccountnumber);

	@Query("SELECT r.wid FROM WalletAccount r where r.walletaccountnumber = :walletaccountnumber")
	int findIdByaccountnumber(@Param("walletaccountnumber") Long walletaccountnumber);
	
	@Query("SELECT r.wbalance FROM WalletAccount r where r.wid = :wid")
	int findbalanceById(int wid);
}

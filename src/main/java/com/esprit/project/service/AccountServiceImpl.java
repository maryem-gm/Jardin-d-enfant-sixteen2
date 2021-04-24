package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Account;
import com.esprit.project.repository.AccountRepository;



@Service
public class AccountServiceImpl implements IAccountService{
	
	
	@Autowired
	private AccountRepository accountRepository;
	
	private static final Logger l = LogManager.getLogger(AccountServiceImpl.class);
	
	@Override
	public List<Account> retrieveAllAccounts(){
		List<Account> accounts = (List<Account>) accountRepository.findAll();
		for (Account account : accounts){
			l.info("account : " + account);
		}
		return accounts;
	}
	@Override
	public Account addAccount(Account acc){
		return accountRepository.save(acc);
		
	}
	@Override
	public void deleteAccount(String id){
		long id1 = Long.parseLong(id);
		accountRepository.deleteById(id1);
	}
	@Override
	public Account updateAccount(Account acc){
		return accountRepository.save(acc);
	}
	@Override
	public Optional<Account> retrieveAccount(String id){
		Optional<Account> account = accountRepository.findById(Long.parseLong(id));
		l.info("account :" + account);
		return account;
	}
}

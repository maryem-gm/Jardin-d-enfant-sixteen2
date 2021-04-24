package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Account;






public interface IAccountService {

	List<Account> retrieveAllAccounts();
	Account addAccount(Account acc);
	void deleteAccount(String id);
	Account updateAccount(Account acc);
	Optional<Account> retrieveAccount(String id);
}

package com.esprit.project.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Account;




@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	
}

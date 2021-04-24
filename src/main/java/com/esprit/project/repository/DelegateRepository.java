package com.esprit.project.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Delegate;





@Repository
public interface DelegateRepository extends CrudRepository<Delegate, Long> {
	
}

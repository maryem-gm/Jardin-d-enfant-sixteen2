package com.esprit.project.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Administrator;





@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
	
}

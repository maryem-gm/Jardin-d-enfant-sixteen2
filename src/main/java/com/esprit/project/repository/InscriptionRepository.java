package com.esprit.project.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Inscription;





@Repository
public interface InscriptionRepository extends CrudRepository<Inscription, Long> {
	
}

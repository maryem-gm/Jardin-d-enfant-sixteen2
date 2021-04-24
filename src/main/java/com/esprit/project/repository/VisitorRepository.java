package com.esprit.project.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Visitor;




@Repository
public interface VisitorRepository extends CrudRepository<Visitor, Long> {
	
}

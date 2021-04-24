package com.esprit.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Rdv;

@Repository
public interface RdvRepository extends CrudRepository<Rdv,Long>{

}


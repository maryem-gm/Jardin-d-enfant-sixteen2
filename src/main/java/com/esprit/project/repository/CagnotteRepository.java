package com.esprit.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Cagnotte;

@Repository
public interface CagnotteRepository extends CrudRepository<Cagnotte,Long> {
 
}

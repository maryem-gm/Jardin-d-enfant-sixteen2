package com.esprit.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.CategoryOfReclamation;
import com.esprit.project.entity.Reclamation;

@Repository
public interface ReclamationRepository  extends JpaRepository<Reclamation, Long> {
	@Query("SELECT r FROM Reclamation r WHERE r.categoryOfReclamation =:categoryOfReclamation")
	public List<Reclamation> getReclamationByCategory(@Param("categoryOfReclamation")CategoryOfReclamation categoryOfReclamation);
	@Query("SELECT r FROM Reclamation r WHERE r.kinderGarden.id =:id")
	public List<Reclamation> getReclamationByKinderGarden(@Param("id")Long id);
	@Query("SELECT count(c) FROM Reclamation r WHERE r.categoryOfReclamation =:categoryOfReclamation")
	public int isCategoryExists(@Param("categoryOfReclamation")CategoryOfReclamation CategoryOfReclamation);
   
	@Query("SELECT count(k) FROM KinderGarden k WHERE k.id =:id")
    public int iskinderGarden(@Param("id")Long id);
	
	@Query("SELECT count(r) FROM Reclamation r WHERE r.kinderGarden.id=:id")
	public int isKinderGardenReclamationExists(@Param("id")Long id);
	

	

}

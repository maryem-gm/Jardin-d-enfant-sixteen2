package com.esprit.project.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.CategoryOfReclamation;
import com.esprit.project.entity.Parent;
import com.esprit.project.entity.Reclamation;



public interface IReclamationService {
	void store(Long garden_id, Reclamation reclamation, String mailTo) throws IOException;
	  List<Reclamation> retrieveAllReclamations();
	  Optional<Reclamation> retrieveReclamation(String recId);
	  Reclamation updateReclamation(Reclamation r);
	  void deleteReclamationById(String id);
	  List<Reclamation> getReclamationByKindergarden(Long id);
	  boolean isCategoryExists(CategoryOfReclamation categoryOfReclamation);
	  boolean isKinderGarden(Long id);
	  int CountReclamationByKindergarden(Long id);
	  int CountSkipedReclamationByKindergarden(Long id);
	  boolean isKindergardenReclamationExists(Long id);
	  int CountProcessingReclamationByKinderGarden(Long id);
	Reclamation findById(Long id);

}

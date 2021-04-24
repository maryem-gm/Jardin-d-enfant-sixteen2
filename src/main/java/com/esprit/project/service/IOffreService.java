package com.esprit.project.service;

import java.util.List;
import java.util.Map;

import com.esprit.project.entity.Offre;
import com.esprit.project.entity.TypeOffre;



public interface IOffreService {

	Offre addOffre(Offre offre);
	List<Offre> retrieveAllOffres();
	void deleteOffreById(Long id);
	Offre updateOffre(Offre offre);
	Offre retrieveOffreById(Long id);
	String addOffreToKinderGarden(Long idKinderGarden, Long idOffre);
	String addOffreToParent(Long idParent, Long idOffre);
	int getNbrParticipants(Long idOffre);
	List<Offre> filterOffre(TypeOffre typeOffre);
	Map<Integer, String> getOffreByPrice();	
	
}

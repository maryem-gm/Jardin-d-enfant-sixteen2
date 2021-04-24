package com.esprit.project.service;

import java.util.List;
import java.util.Optional;


import com.esprit.project.entity.Inscription;






public interface IInscriptionService {

	List<Inscription> retrieveAllInscriptions();
	Inscription addInscription(Inscription inscription);
	void deleteInscription(String id);
	Inscription updateInscription(Inscription inscription);
	Optional<Inscription> retrieveInscription(String id);
}

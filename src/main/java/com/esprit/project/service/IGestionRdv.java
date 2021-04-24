package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Rdv;


public interface IGestionRdv {

	List<Rdv> retrieveAllRdvs();
	Rdv addRdv(Rdv rdv);
	void deleteRdv(String idRdv);
	Rdv updateRdv(Rdv rdv);
	Optional<Rdv> retrieveRdv(String idRdv);
}

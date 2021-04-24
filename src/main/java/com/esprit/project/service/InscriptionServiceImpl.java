package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.esprit.project.entity.Inscription;
import com.esprit.project.repository.InscriptionRepository;



@Service
public class InscriptionServiceImpl implements IInscriptionService{
	
	
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	private static final Logger l = LogManager.getLogger(InscriptionServiceImpl.class);
	
	@Override
	public List<Inscription> retrieveAllInscriptions(){
		List<Inscription> inscriptions = (List<Inscription>) inscriptionRepository.findAll();
		for (Inscription inscription : inscriptions){
			l.info("Inscription :" + inscription);
		}
		return inscriptions;
	}
	@Override
	public Inscription addInscription(Inscription inscription){
		return inscriptionRepository.save(inscription);
		
	}
	@Override
	public void deleteInscription(String id){
		long id1 = Long.parseLong(id);
		inscriptionRepository.deleteById(id1);
	}
	@Override
	public Inscription updateInscription(Inscription inscription){
		return inscriptionRepository.save(inscription);
	}
	@Override
	public Optional<Inscription> retrieveInscription(String id){
		Optional<Inscription> inscription = inscriptionRepository.findById(Long.parseLong(id));
		l.info("Inscription :" + inscription);
		return inscription;
	}
}

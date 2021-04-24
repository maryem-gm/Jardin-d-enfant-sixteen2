package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.esprit.project.entity.Administrator;
import com.esprit.project.repository.AdministratorRepository;



@Service
public class AdministratorServiceImpl implements IAdministratorService{
	
	
	@Autowired
	private AdministratorRepository administratorRepository;
	
	private static final Logger l = LogManager.getLogger(AdministratorServiceImpl.class);
	
	@Override
	public List<Administrator> retrieveAllAdministrators(){
		List<Administrator> administrators = (List<Administrator>) administratorRepository.findAll();
		for (Administrator administrator : administrators){
			l.info("Administrator :" + administrator);
		}
		return administrators;
	}
	@Override
	public Administrator addAdministrator(Administrator admin){
		return administratorRepository.save(admin);
		
	}
	@Override
	public void deleteAdministrator(String id){
		long id1 = Long.parseLong(id);
		administratorRepository.deleteById(id1);
	}
	@Override
	public Administrator updateAdministrator(Administrator admin){
		return administratorRepository.save(admin);
	}
	@Override
	public Optional<Administrator> retrieveAdministrator(String id){
		Optional<Administrator> administrator = administratorRepository.findById(Long.parseLong(id));
		l.info("Administrator :" + administrator);
		return administrator;
	}
}

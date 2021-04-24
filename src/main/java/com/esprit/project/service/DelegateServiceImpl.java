package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.esprit.project.entity.Delegate;
import com.esprit.project.repository.DelegateRepository;



@Service
public class DelegateServiceImpl implements IDelegateService{
	
	
	@Autowired
	private DelegateRepository delegateRepository;
	
	private static final Logger l = LogManager.getLogger(DelegateServiceImpl.class);
	
	@Override
	public List<Delegate> retrieveAllDelegates(){
		List<Delegate> delegates = (List<Delegate>) delegateRepository.findAll();
		for (Delegate delegate : delegates){
			l.info("Delegate :" + delegate);
		}
		return delegates;
	}
	@Override
	public Delegate addDelegate(Delegate delegate){
		return delegateRepository.save(delegate);
		
	}
	@Override
	public void deleteDelegate(String id){
		long id1 = Long.parseLong(id);
		delegateRepository.deleteById(id1);
	}
	@Override
	public Delegate updateDelegate(Delegate delegate){
		return delegateRepository.save(delegate);
	}
	@Override
	public Optional<Delegate> retrieveDelegate(String id){
		Optional<Delegate> delegate = delegateRepository.findById(Long.parseLong(id));
		l.info("Delegate :" + delegate);
		return delegate;
	}
}

package com.esprit.project.service;

import java.util.List;
import java.util.Optional;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.KinderGarden;
import com.esprit.project.entity.Parent;
import com.esprit.project.entity.User;
import com.esprit.project.repository.ParentRepository;


@Service
public class ParentServiceImpl implements IParentService{
	
	
	@Autowired
	
	 ParentRepository ParentRepository;
	private static final Logger l = LogManager.getLogger(ParentServiceImpl.class);
	
	@Override
	public List<Parent> retrieveAllParents(){
		List<Parent> parents = (List<Parent>) ParentRepository.findAll();
		System.out.println(parents);
		for (User parent : parents){
			l.info("Parent :" + parent);
		}
		return parents;
	}
	@Override
	public Parent addParent(Parent parent){
		return ParentRepository.save(parent);
		
	}
	@Override
	
	public void deleteParent(Long id){
		ParentRepository.deleteById(id);
	}
	@Override

	public Parent updateParent(Parent parent){
		return ParentRepository.save(parent);
	}
	@Override
	
	public Optional<Parent> retrieveParent(Long id){
		Optional<Parent> parent = ParentRepository.findById(id);
		l.info("Parent :" + parent);
		return parent;
	}
	
	
}

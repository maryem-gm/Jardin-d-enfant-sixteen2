package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.esprit.project.entity.Visitor;
import com.esprit.project.repository.VisitorRepository;



@Service
public class VisitorServiceImpl implements IVisitorService{
	
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	private static final Logger l = LogManager.getLogger(VisitorServiceImpl.class);
	
	@Override
	public List<Visitor> retrieveAllVisitors(){
		List<Visitor> visitors = (List<Visitor>) visitorRepository.findAll();
		for (Visitor visitor : visitors){
			l.info("Visitor :" + visitor);
		}
		return visitors;
	}
	@Override
	public Visitor addVisitor(Visitor visitor){
		return visitorRepository.save(visitor);
		
	}
	@Override
	public void deleteVisitor(String id){
		long id1 = Long.parseLong(id);
		visitorRepository.deleteById(id1);
	}
	@Override
	public Visitor updateVisitor(Visitor visitor){
		return visitorRepository.save(visitor);
	}
	@Override
	public Optional<Visitor> retrieveVisitor(String id){
		Optional<Visitor> visitor = visitorRepository.findById(Long.parseLong(id));
		l.info("Visitor :" + visitor);
		return visitor;
	}
}

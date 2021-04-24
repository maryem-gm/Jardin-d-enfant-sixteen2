package com.esprit.project.service;

import java.util.List;
import java.util.Optional;



import com.esprit.project.entity.Visitor;






public interface IVisitorService {

	List<Visitor> retrieveAllVisitors();
	Visitor addVisitor(Visitor visitor);
	void deleteVisitor(String id);
	Visitor updateVisitor(Visitor visitor);
	Optional<Visitor> retrieveVisitor(String id);
}

package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Parent;






public interface IParentService {

	List<Parent> retrieveAllParents();
	Parent addParent(Parent parent);
	void deleteParent(Long id);
	Parent updateParent(Parent parent);
	Optional<Parent> retrieveParent(Long id);
	
}

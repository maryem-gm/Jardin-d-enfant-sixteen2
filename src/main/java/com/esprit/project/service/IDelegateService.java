package com.esprit.project.service;

import java.util.List;
import java.util.Optional;


import com.esprit.project.entity.Delegate;






public interface IDelegateService {

	List<Delegate> retrieveAllDelegates();
	Delegate addDelegate(Delegate delegate);
	void deleteDelegate(String id);
	Delegate updateDelegate(Delegate delegate);
	Optional<Delegate> retrieveDelegate(String id);
}

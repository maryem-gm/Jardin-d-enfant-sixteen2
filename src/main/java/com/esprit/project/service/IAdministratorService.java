package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Administrator;






public interface IAdministratorService {

	List<Administrator> retrieveAllAdministrators();
	Administrator addAdministrator(Administrator admin);
	void deleteAdministrator(String id);
	Administrator updateAdministrator(Administrator admin);
	Optional<Administrator> retrieveAdministrator(String id);
}

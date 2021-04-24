package com.esprit.project.control;

/*import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;*/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.esprit.project.entity.Account;
//import com.esprit.project.entity.Administrator;
//import com.esprit.project.entity.Delegate;
import com.esprit.project.entity.Inscription;
//import com.esprit.project.entity.User;
//import com.esprit.project.service.IAccountService;
//import com.esprit.project.service.IAdministratorService;
//import com.esprit.project.service.IDelegateService;
import com.esprit.project.service.IInscriptionService;
//import com.esprit.project.service.IUserService;



@RestController
public class InscriptionRestController {
	
	@Autowired 
	IInscriptionService inscriptionService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-inscriptions
	@GetMapping("/retrieve-all-inscriptions")
	@ResponseBody
	public List<Inscription> getInscription() {
	List<Inscription> list = inscriptionService.retrieveAllInscriptions();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-inscription/{inscription-id}
	@GetMapping("/retrieve-inscription/{inscription-id}")
	@ResponseBody
	public Optional<Inscription> retrieveInscription(@PathVariable("inscription-id") String inscriptionId) {
	return inscriptionService.retrieveInscription(inscriptionId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-inscription
	@PostMapping("/add-inscription")
	@ResponseBody
	public Inscription addInscription(@RequestBody Inscription inscription1) {
	Inscription inscription = inscriptionService.addInscription(inscription1);
	return inscription;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-inscription/{inscription-id}
	@DeleteMapping("/remove-inscription/{inscription-id}")
	@ResponseBody
	public void removeInscription(@PathVariable("inscription-id") String inscriptionId) {
		inscriptionService.deleteInscription(inscriptionId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-inscription
	@PutMapping("/modify-inscription")
	@ResponseBody
	public Inscription modifyInscription(@RequestBody Inscription inscription) {
	return inscriptionService.updateInscription(inscription);
	}
	
	/*
	/ http://localhost:8081/SpringMVC/servlet/retrive-user-jpql/{d1}/{d2}
	@GetMapping("/retrive-user-jpql/{d1}/{d2}")
	@ResponseBody
	public List<User> retrieveUserbybirthdate(@PathVariable("d1") String d1,@PathVariable("d2") String d2) throws ParseException {
	Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d1);  
	Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(d2);
	return userService.retrieveUsersByBirthDate(date1, date2);
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrive-user-sql/{date1}/{date2}
	@GetMapping("retrive-user-sql/{date1}/{date2}")
	@ResponseBody
	public List<User> retrieveUserbybirthdateSql(@PathVariable("date1") String d1,@PathVariable("date2") String d2) throws ParseException {
	Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d1);  
	Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(d2);
	return userService.retrieveUsersByBirthDatesql(date1, date2);
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-user-role/{role}
	@GetMapping("/retrieve-user-role/{role}")
	@ResponseBody
	public List<User> retrieveUserbybirthdateRole(@PathVariable("role") Role role) {
	return userService.retrieveUsersByRole(role);
		}*/
}

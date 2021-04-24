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
import com.esprit.project.entity.Delegate;
//import com.esprit.project.entity.User;
//import com.esprit.project.service.IAccountService;
//import com.esprit.project.service.IAdministratorService;
import com.esprit.project.service.IDelegateService;
//import com.esprit.project.service.IUserService;



@RestController
public class DelegateRestController {
	
	@Autowired 
	IDelegateService delegateService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-delegates
	@GetMapping("/retrieve-all-delegates")
	@ResponseBody
	public List<Delegate> getDelegate() {
	List<Delegate> list = delegateService.retrieveAllDelegates();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-delegate/{delegate-id}
	@GetMapping("/retrieve-delegate/{delegate-id}")
	@ResponseBody
	public Optional<Delegate> retrieveDelegate(@PathVariable("delegate-id") String delegateId) {
	return delegateService.retrieveDelegate(delegateId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-delegate
	@PostMapping("/add-delegate")
	@ResponseBody
	public Delegate addDelegate(@RequestBody Delegate delegate1) {
	Delegate delegate = delegateService.addDelegate(delegate1);
	return delegate;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-delegate/{delegate-id}
	@DeleteMapping("/remove-delegate/{delegate-id}")
	@ResponseBody
	public void removeDelegate(@PathVariable("delegate-id") String delegateId) {
		delegateService.deleteDelegate(delegateId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-delegate
	@PutMapping("/modify-delegate")
	@ResponseBody
	public Delegate modifyDelegate(@RequestBody Delegate delegate) {
	return delegateService.updateDelegate(delegate);
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

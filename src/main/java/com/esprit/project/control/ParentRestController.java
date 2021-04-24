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
//import com.esprit.project.entity.Inscription;
//import com.esprit.project.entity.KinderGarden;
import com.esprit.project.entity.Parent;
//import com.esprit.project.entity.User;
//import com.esprit.project.service.IAccountService;
//import com.esprit.project.service.IAdministratorService;
//import com.esprit.project.service.IDelegateService;
//import com.esprit.project.service.IInscriptionService;
//import com.esprit.project.service.IUserService;
//import com.esprit.project.service.IKinderGardenService;
import com.esprit.project.service.IParentService;


@RestController
public class ParentRestController {
	
	@Autowired 
	IParentService parentService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-parents
	@GetMapping("/retrieve-all-parents")
	@ResponseBody
	public List<Parent> getParents() {
	List<Parent> list = parentService.retrieveAllParents();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-parent/{parent-id}
	@GetMapping("/retrieve-parent/{id}")
	@ResponseBody
	public Optional<Parent> retrieveParent(@PathVariable("id") Long id) {
	return parentService.retrieveParent(id);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-parent
	@PostMapping("/add-parent")
	@ResponseBody
	public Parent addParent(@RequestBody Parent p) {
	Parent parent = parentService.addParent(p);
	return parent;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-parent/{parent-id}
	@DeleteMapping("/remove-parent/{id}")
	@ResponseBody
	public void removeParent(@PathVariable("id") Long id) {
		parentService.deleteParent(id);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-parent
	@PutMapping("/modify-parent")
	@ResponseBody
	public Parent modifyParent(@RequestBody Parent parent) {
	return parentService.updateParent(parent);
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

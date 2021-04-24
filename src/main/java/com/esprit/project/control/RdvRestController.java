package com.esprit.project.control;

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

import com.esprit.project.entity.Rdv;
import com.esprit.project.service.IGestionRdv;

@RestController
public class RdvRestController {
	
	@Autowired 
	IGestionRdv gestionRdv;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-rdvs
	@GetMapping("/retrieve-all-rdvs")
	@ResponseBody
	public List<Rdv> getRdvs() {
	List<Rdv> list = gestionRdv.retrieveAllRdvs();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-rdv/{rdv-id}
	@GetMapping("/retrieve-rdv/{rdv-id}")
	@ResponseBody
	public Optional<Rdv> retrieveRdv(@PathVariable("rdv-id") String idRdv) {
	return gestionRdv.retrieveRdv(idRdv);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-rdv
	@PostMapping("/add-rdv")
	@ResponseBody
	public Rdv addRdv(@RequestBody Rdv rdv1) {
	Rdv rdv = gestionRdv.addRdv(rdv1);
	return rdv;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-rdv/{rdv-id}
	@DeleteMapping("/remove-rdv/{rdv-id}")
	@ResponseBody
	public void removeRdv(@PathVariable("rdv-id") String idRdv) {
	gestionRdv.deleteRdv(idRdv);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-rdv
	@PutMapping("/modify-rdv")
	@ResponseBody
	public Rdv modifyRdv(@RequestBody Rdv rdv) {
	return gestionRdv.updateRdv(rdv);
	}
}

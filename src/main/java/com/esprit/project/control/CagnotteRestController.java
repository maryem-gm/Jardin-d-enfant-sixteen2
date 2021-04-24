package com.esprit.project.control;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Cagnotte;

import com.esprit.project.service.ICagnotteService;
import com.esprit.project.service.IEventService;


@RestController
public class CagnotteRestController {
	

	@Autowired
	ICagnotteService cagnotteService;
	@Autowired
	IEventService eventService;
	
	//http://localhost:8081/SpringMVC/servlet/AfficherCagnottes
	@GetMapping("/AfficherCagnottes")
	@ResponseBody
	public List<Cagnotte> getCagnottes() {
	List<Cagnotte> Cagnotte = cagnotteService.retrieveAllCagnotte();
	return Cagnotte;
	}
	
	//http://localhost:8081/SpringMVC/servlet/AjouterCagnotte
	@PostMapping("/AjouterCagnotte")
	@ResponseBody
	public Cagnotte addCagnotte(@RequestBody Cagnotte C) {
		Cagnotte cagnotte = cagnotteService.save(C);
	return cagnotte;

}
	
	
	
}

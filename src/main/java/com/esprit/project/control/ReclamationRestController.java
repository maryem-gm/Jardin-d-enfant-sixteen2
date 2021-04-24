package com.esprit.project.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Reclamation;
import com.esprit.project.service.IGestionMailing;
import com.esprit.project.service.IReclamationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin("*")
public class ReclamationRestController {
	
	
	@Autowired 
	IGestionMailing gestionMailing;
	
	@Autowired 
	IReclamationService reclamationService;
	//http://localhost:8081/addReclamation
	  @PostMapping(value = "/addReclamation") 
	  public ResponseEntity uploadReclamation(@RequestParam("garden_id") Long garden_id, @RequestParam("reclamation") String reclamation) {
		  String messageResponse = "";
		  String mailTo = "";
		  Reclamation rec = new Reclamation();
		  try { 
			  
			  rec = new ObjectMapper().readValue(reclamation, Reclamation.class);
			  
			  if(rec.getCategoryOfReclamation()== "Technical") {
				  mailTo = "maryem.gomri@esprit.tn";
			  }else {
				  mailTo = "maryem.gomri@esprit.tn";
			  }
			  
			  reclamationService.store(garden_id, rec, mailTo);
			  
			  messageResponse = "Uploaded successfully: ";
	  
		  	return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
	  
	  } catch (Exception e) { e.printStackTrace(); 
	  			messageResponse = "Could not upload the reclamation!"; 
	  			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(messageResponse); }
		  }
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-reclamations
		@GetMapping("/retrieve-all-reclamations")
		@ResponseBody
		public List<Reclamation> getReclamations() {
		List<Reclamation> Reclamation = reclamationService.retrieveAllReclamations();
		return Reclamation;
		}
	// http://localhost:8081/SpringMVC/servlet/retrieve-reclamation/{reclamation-id}
			@GetMapping("/retrieve-reclamation/{reclamation-id}")
			@ResponseBody
			public Optional<Reclamation> retrieveReclamation(@PathVariable("reclamation-id") String id) {
			return reclamationService.retrieveReclamation(id);
			}

	// http://localhost:8081/SpringMVC/servlet/modify-reclamation
			@PutMapping("/modify-reclamation")
			@ResponseBody
			public Reclamation modifyReclamation(@RequestBody Reclamation reclamation) {
			return reclamationService.updateReclamation(reclamation);
			}
	// http://localhost:8081/SpringMVC/servlet/remove-reclamation/{reclamation-id}
			@DeleteMapping("/remove-reclamation/{reclamation-id}")
			@ResponseBody
			public void removeReclamation(@PathVariable("reclamation-id") String id) {
				reclamationService.deleteReclamationById(id);
			} 
	// http://localhost:8081/SpringMVC/servlet/retrieve-reclamation-kinderGarden/{id}
			
			@GetMapping("/retrieve-reclamation-kinderGarden/{id}")
			public String getReclamationByKinderGarden(@PathVariable Long id) {
			
			if (reclamationService.isKinderGarden(id)){
				List<Reclamation> reclamation = reclamationService.getReclamationByKindergarden(id);
				
				
				if(!reclamation.isEmpty())
					return reclamation.toString();
					
				else
				return "No reclamation found for this kindergarden";
				
			}
			return "Sorry this kindergarden id not found.";
			
}
	// http://localhost:8081/SpringMVC/servlet/kinderGarden-Reclamations-number/{id}

			@GetMapping("/kinderGarden-Reclamations-number/{id}")
			 @ResponseBody
			public int CountReclamationByKindergarden(@PathVariable Long id) {
				 
					return reclamationService.CountReclamationByKindergarden(id);
				}
	// http://localhost:8081/SpringMVC/servlet/kinderGarden-skiped-reclamations/{id}

			@GetMapping("/kinderGarden-skiped-reclamations/{id}")
			 @ResponseBody
			public int CountSkipedReclamationByKindergarden(@PathVariable Long id) {
				 
					return reclamationService.CountSkipedReclamationByKindergarden(id);
				}
	// http://localhost:8081/SpringMVC/servlet/kinderGarden-processing-reclamations/{id}

			@GetMapping("/kinderGarden-processing-reclamations/{id}")
			 @ResponseBody
			public int CountProcessingReclamationByKinderGarden(@PathVariable Long id) {
				 
					return reclamationService.CountProcessingReclamationByKinderGarden(id);
				}
	}



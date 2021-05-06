package com.esprit.project.control;

/*import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Offre;
import com.esprit.project.entity.TypeOffre;
import com.esprit.project.service.IOffreService;


@RestController
public class OffreRestController {
	
	
	@Autowired
	IOffreService offreService;
	
	// http://localhost:8084/SpringMVC/servlet/add-offre
		@PostMapping("/add-offre")
		@ResponseBody
		public Offre addOffre(@RequestBody Offre o) {
			Offre offre = offreService.addOffre(o);
		return offre;
		}
		// http://localhost:8084/SpringMVC/servlet/update-offre
		@PutMapping("/update-offre")
		@ResponseBody
		public Offre updateOffre(@RequestBody Offre o) {
			Offre offre = offreService.updateOffre(o);
		return offre;
		}
		
		//http://localhost:8084/SpringMVC/servlet/retrieve-all-offres
		@GetMapping("/retrieve-all-offres")
		@ResponseBody
		public List<Offre> getOffres() {
		List<Offre> offre = offreService.retrieveAllOffres();
		return  offre;
		}
		// http://localhost:8084/SpringMVC/servlet/retrieve-offre/{id}
		@GetMapping("/retrieve-offre/{id}")
		@ResponseBody
		public Offre getOffreById(@PathVariable("id") Long id) {
		Offre offre = offreService.retrieveOffreById(id);
		return  offre;
		}
		// http://localhost:8084/SpringMVC/servlet/delete-offre/{id}
		@DeleteMapping("/delete-offre/{id}")
		public String deleteOffre(@PathVariable("id") Long id){
			offreService.deleteOffreById(id);
			return "Offre deleted";
		}
		// http://localhost:8084/SpringMVC/servlet/add-kindergarden/offre/{idKinderGarden}/{idOffre}
		@PostMapping("/add-kindergarden/offre/{idKinderGarden}/{idOffre}")
		public String addKinderGardenToOffre(@PathVariable("idKinderGarden") Long idKinderGarden,@PathVariable("idOffre") Long idOffre){
			return offreService.addOffreToKinderGarden(idKinderGarden, idOffre);
		}
		
		// http://localhost:8084/SpringMVC/servlet/add-Parent/offre/{idParent}/{idOffre}
		@PostMapping("/add-Parent/offre/{idParent}/{idOffre}")
		public String addParentToOffre(@PathVariable("idParent") Long idParent,@PathVariable("idOffre") Long idOffre){
			return offreService.addOffreToParent(idParent, idOffre);
		}
		
		//http://localhost:8084/SpringMVC/servlet/offres/participants/count/{id}
		
				@GetMapping("/offres/participants/count/{id}")
				@ResponseBody
				public Map<String,Object> getDetailsOffre(@PathVariable("id") Long  idOffre) {
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("NbrParticipant", offreService.getNbrParticipants(idOffre));
					return map;
				}
				
				@GetMapping("/offre/retrieve-Offre-ByTypeOffre/{typeOffre}")
				public List<Offre> getOffreByTypeOffre(@PathVariable TypeOffre typeOffre) {
					 List<Offre> o = offreService.filterOffre(typeOffre);
					return o;
					}
				   //http://localhost:8081/SpringMVC/servlet/offre/MostExpensiveOffre
				   @GetMapping("/offre/MostExpensiveOffre")
					public Map<Integer, String> MostExpensiveOffre(){
						return offreService.getOffreByPrice();
						}	

}*/

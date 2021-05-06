package com.esprit.project.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.CategoryOfReclamation;
import com.esprit.project.entity.KinderGarden;
import com.esprit.project.entity.Parent;
import com.esprit.project.entity.Reclamation;
import com.esprit.project.repository.KinderGardenRepository;
import com.esprit.project.repository.ParentRepository;
import com.esprit.project.repository.ReclamationRepository;
import com.esprit.project.repository.UserRepository;




@Service
public class ReclamationService implements IReclamationService {
	@Autowired
	ParentRepository parentRepository;
	@Autowired
	ParentServiceImpl parentservice;
	@Autowired
	ReclamationRepository reclamationRepository;
	@Autowired
	KinderGardenRepository kinderGardenRepository;
	@Autowired
	UserRepository userRepository;
	


	
	@Autowired 
	IGestionMailing gestionMailing;
	
	@Autowired 
	KinderGardenServiceImpl KinderGardenService;
	
	  private static final Logger L = LogManager.getLogger(ReclamationService.class);

	@Override
	public Reclamation findById(Long id) {
		Optional<Reclamation> result = reclamationRepository.findById(id);
		Reclamation reclamation = null;
		
		if(result.isPresent()) {
			reclamation = result.get();
		}
		else {
			return reclamation;
		}
		return reclamation;
	}
	
	  @Override
	  public void store(Long garden_id, Reclamation reclamation, String mailTo) throws IOException {
		  
		  KinderGarden kinderGarden = KinderGardenService.findById(garden_id);
		  int recNbr = kinderGarden.getReclamation_nbr()+1;
		  kinderGarden.setReclamation_nbr(recNbr);
		  if(recNbr > 10) {
			  kinderGarden.setBlocked(true);
		  }
		  Reclamation reclamation1 = new Reclamation(reclamation.getSubject(), reclamation.getDescription(),
				  reclamation.getCategoryOfReclamation(), reclamation.getSenderReclamation(), kinderGarden);
		  reclamationRepository.save(reclamation1);
		  
		  boolean result = this.gestionMailing.sendEmail(reclamation.getSubject(), reclamation.getDescription(), mailTo);
	  
	  }
	  @Override
	  public List<Reclamation> retrieveAllReclamations() {
		List<Reclamation> reclamations = (List<Reclamation>) reclamationRepository.findAll();
		for (Reclamation reclamation: reclamations) {
			L.info("reclamation : " + reclamation);
		}
		return reclamations;}
	  @Override
	  public Optional<Reclamation> retrieveReclamation(String id){
	  	Optional<Reclamation> reclamation = reclamationRepository.findById(Long.parseLong(id));
	  	L.info("reclamation : " + reclamation);
	  	return reclamation;
	  }
	  @Override
	  public Reclamation updateReclamation(Reclamation r) {
	  	return reclamationRepository.save(r);	
	  }
	  @Override
	  public void deleteReclamationById(String id) {

	  	 reclamationRepository.deleteById(Long.parseLong(id));
	  }
	  @Override
	  public List<Reclamation> getReclamationByKindergarden(Long id) {
	  	// TODO Auto-generated method stub
	  	
	  	
	  	return reclamationRepository.getReclamationByKinderGarden(id);
	  }
	  public boolean isCategoryExists(CategoryOfReclamation categoryOfReclamation){
			
			if(reclamationRepository.isCategoryExists(categoryOfReclamation)==0)
				return false;
			else

			return true;
		}
	  public boolean isKinderGarden(Long id){
			
			if(reclamationRepository.iskinderGarden(id)==0)
				return false;
			else

			return true;
		}
		@Override
		public int CountReclamationByKindergarden(Long id) {
			// TODO Auto-generated method stub
			
			List <Reclamation> reclamations=(List<Reclamation>) reclamationRepository.getReclamationByKinderGarden(id);
			return reclamations.size();
			
		}
		@Override
		public int CountSkipedReclamationByKindergarden(Long id) {
			return 0;
			// TODO Auto-generated method stub
			

		}

		public boolean isKindergardenReclamationExists(Long id){

		if(reclamationRepository.isKinderGardenReclamationExists(id)==0)
			return false;
		else

		return true;
		}


		@Override
		public 	int CountProcessingReclamationByKinderGarden(Long id)
		 {
			return 0;
			// TODO Auto-generated method stub
			
			
		}
		@Override
		public void affecterReclamationAParent(Long recId, Long id) {
			Parent p = parentRepository.findById(id).get();
			Reclamation r= reclamationRepository.findById(recId).get();
			r.setParent(p);
			reclamationRepository.save(r);


}
}


package com.esprit.project.service;

/*import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.KinderGarden;
import com.esprit.project.entity.Offre;
import com.esprit.project.entity.Parent;
import com.esprit.project.entity.TypeOffre;
import com.esprit.project.repository.KinderGardenRepository;
import com.esprit.project.repository.OffreRepository;
import com.esprit.project.repository.ParentRepository;

@Service
public class OffreService implements IOffreService {
	
	@Autowired
	 OffreRepository offreRepository;
	@Autowired
	 KinderGardenRepository kinderGardenRepository;
	@Autowired
	 ParentRepository parentRepository;
	
	
	private static final Logger l = LogManager.getLogger(OffreService.class);
	
	public static Logger getL() {
		return l;
	}
	
	@Override
	public Offre addOffre(Offre offre){
		return offreRepository.save(offre);
		

}
	@Override
	public Offre updateOffre(Offre offre){
		return offreRepository.save(offre);
		

}
	

	@Override
	public List<Offre> retrieveAllOffres() {
		
		 return (List<Offre>) offreRepository.findAll();
	}
	@Override
	public Offre retrieveOffreById(Long id){
		return offreRepository.findById(id).get();
	}
	
	@Override
	public void deleteOffreById(Long id){
		offreRepository.deleteById(id);
	}
	
	@Override
	public String addOffreToKinderGarden(Long idKinderGarden, Long idOffre){
		System.out.println("Long idKinderGarden "+idKinderGarden+" Long idOffre "+idOffre);
		Optional<Offre> o = offreRepository.findById(idOffre);
		System.out.println("offre "+o.get());
		if(o.isPresent()){
			Optional<KinderGarden> kg = kinderGardenRepository.findById(idKinderGarden);
			System.out.println("kg "+kg.get());
			if(kg.isPresent()){
				o.get().setKindergardens(kg.get());
				offreRepository.save(o.get());
				kg.get().getOffres().add(o.get());
				System.out.println(kg.get().getOffres());
				kinderGardenRepository.save(kg.get());
				return "offre associated to kinderGarden";
			 }
		}
		return "A problem occured";
		}
	
		@Transactional
		public String addOffreToParent(Long idParent, Long idOffre){
			System.out.println("Long Parent "+idParent+" Long idOffre "+idOffre);
			Optional<Offre> o = offreRepository.findById(idOffre);
			System.out.println("offre "+o.get());
			if(o.isPresent()){
				Optional<Parent> P = parentRepository.findById(idParent);
				System.out.println("P "+P.get());
				if(P.isPresent()){
					System.out.println("Parent is present");
					System.out.println(P.get().getOffreParent());
					P.get().getOffreParent().add(o.get());
					/*o.get().setParents((List<Parent>) P.get());
					OffreRepository.save(o.get());
					P.get().getOffres().add(o.get());
					System.out.println(P.get().getOffres());*/
			//	parentRepository.save(P.get());
				//	return "offre associated to Parent";
				//}	
			//} 
			//return "A problem occured";
	//}
	
	/*	@Override
	 	public int  getNbrParticipants(Long idOffre) {
			int nbParticipants=0;
	 		System.out.println("Present");
			nbParticipants= offreRepository.getNbrParticipants(idOffre);
			return nbParticipants;
	 	}
		
		//creating filterOffre method that filter offre by his typeOffre
		@Override
		public List<Offre> filterOffre(TypeOffre typeOffre) {
			// TODO Auto-generated method stub
			return offreRepository.findOffreByType(typeOffre);
		} 
		
		@Override
		public Map<Integer, String> getOffreByPrice() {
			List<Integer>listId = new ArrayList<>();
			List<Integer>listPrices = new ArrayList<>();
			Map<Integer,String> h = new HashMap<>();
			
			for(Offre o : offreRepository.findAll()) {
				
				listId.add(Math.toIntExact(o.getId()));
				listPrices.add(Integer.valueOf(o.getPrix()));
				
			}
			List<Integer>sortedList = new ArrayList<>(listPrices);
			Collections.sort(sortedList);
			
			for(int i = 0 ; i <1 ; i++) {
	     	int  max = sortedList.get(Integer.valueOf(sortedList.size()-1));
				int ind = listId.get(listPrices.indexOf(max));
				h.put(ind, max+"");

				System.out.println(ind +" "+ max);
				sortedList.remove(sortedList.size()-1);
				listPrices.set( listPrices.indexOf(max),-1);
			}
			return h;
		}
		
		
		
		
		
}*/


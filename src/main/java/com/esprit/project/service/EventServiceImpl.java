package com.esprit.project.service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.project.entity.Cagnotte;
import com.esprit.project.entity.CategoryEvent;
import com.esprit.project.entity.Event;
import com.esprit.project.entity.KinderGarden;
import com.esprit.project.entity.Parent;
import com.esprit.project.repository.CagnotteRepository;
import com.esprit.project.repository.EventRepository;
import com.esprit.project.repository.KinderGardenRepository;
import com.esprit.project.repository.ParentRepository;



@Service 
public class EventServiceImpl implements IEventService {
	
	
	@Autowired
	EventRepository eventRepository;
	@Autowired
	ParentRepository parentRepository;
	@Autowired
	CagnotteRepository cagnotteRepository;
	@Autowired
	ParentServiceImpl ps ;
	@Autowired 
	KinderGardenRepository kindergartenRepository;
	@Autowired 
	com.esprit.project.service.Service service;
	private static final Logger L = LogManager.getLogger(EventServiceImpl.class);
	

	@Override
	public Event addEvents(Event e) {
		Cagnotte c = new Cagnotte();
		c.setTotalAmount(0);
		c = cagnotteRepository.save(c);
		e.setCagnotte(c);
		return eventRepository.save(e);
		
	}

	@Override
	public void deleteEventById(String idEvent) {
		eventRepository.deleteById(Long.parseLong(idEvent));
		
	}

	
	@Override
	public Event updateEvents(Event E) {
		Event oldEvent = eventRepository.findById(E.getidEvent()).get();
		String changedThings="" ;
		String message = "";
		SmsRequest smsRequest ;
		if(oldEvent.getDate()!= E.getDate())	
		changedThings+="\nDate changed from "+oldEvent.getDate()+" to "+E.getDate() ;
		System.out.println("changed date");
		if(oldEvent.getStartHour()!= E.getStartHour())
			changedThings+="\nStart hour changed from "+oldEvent.getStartHour()+" to "+E.getStartHour() ;
		if(oldEvent.getEndHour()!= E.getEndHour())
			changedThings+="\nEnd hour changed from "+oldEvent.getEndHour()+" to "+E.getEndHour() ;
		if (oldEvent.getJackpotDonation()!= E.getJackpotDonation())
			changedThings+="\nPrice changed from "+oldEvent.getJackpotDonation()+" to "+E.getJackpotDonation(); 
			if (oldEvent.getLocation().equals(E.getLocation()) )
			changedThings+="\nLocation changed from "+oldEvent.getLocation()+" to "+E.getLocation() ;
			if(oldEvent.getidEvent()!=E.getJackpotDonation())
				changedThings+="\njackpotdonation was changed to "+oldEvent.getJackpotDonation()+"to"+E.getJackpotDonation();
	System.out.println("we have chnage ");
		//for(KinderGarden kg : E.getKindergartens()){
			System.out.println("enter to inscription");
			//for(Inscription in : kindergarten.getInscriptions()){
				System.out.println("got to parent");
				//for(Parent par: in.getParents())
				List<Parent> parents = (List<Parent>) parentRepository.findAll();
				//if( parentRepository.findById(id).isPresent())
				for(Parent parent: parents){
				message = "Bonjour  Mr/Mme  " +parent.getFirstName() +""+parent.getLastName()+ "l'evenement " 
						+E.getName()+""+" est change, plus de details : " +changedThings;
				smsRequest = new SmsRequest("+216"+parent.getPhone(), message);
				service.sendSms(smsRequest);
				}
				
				List<KinderGarden> kindergartens = (List<KinderGarden>) kindergartenRepository.findAll();
				for(KinderGarden kindergarten: kindergartens){
				message = "Bonjour  Mr/Mme  " +kindergarten.getFirstName() +""+kindergarten.getLastName()+ "l'evenement " 
						+E.getName()+""+" est change, plus de details : " +changedThings;
				smsRequest = new SmsRequest("+216"+kindergarten.getPhone(), message);
				//service.sendSms(smsRequest);
				}
				
			//}
		//}
		
		
		return eventRepository.save(E);
		
	}
	

	@Override
	public List<Event> retrieveAllEvents() {
		/*List<Event> events = (List<Event>) eventRepository.findAll();
		for (Event event :  events){
			L.info("event +++ : " + event);
		}
		return   events ;*/
		return (List<Event>) eventRepository.findAll();
	}

	@Override
	public Optional<Event> retrieveEvents(String id) {
		Optional<Event> u = eventRepository.findById(Long.parseLong(id));
		return  u ;
		
	}

	public static Logger getL() {
		return L;
	}
	
/*	public void parentJoinEvent(Long idEvent,  Long id) {
		
    	  
    	if   
    	    ( parentRepository.findById(id).isPresent())
    	{
    	 Parent parententity =   parentRepository.findById(id).get();
    	 Event    eventEntity = eventRepository.findById(idEvent).get();
    	 System.out.println(eventEntity);
    	 System.out.println(parententity);
    
    	  parententity.getEvents().add(eventEntity);
    	  System.out.println(parententity);
    	 // ps.updateParent(parententity);
    	  //parententity.setid(id);
    	 //List <Event> evts = parententity.getEvents();
    	 // evts.add(eventEntity);
    	 // parententity.setEvents(evts);
    	  //System.out.println("saving..");
    	  parententity.getEvents().add(eventEntity);
    	  parentRepository.save(parententity);
    	 //eventEntity.getParents().add(parententity);
    	 //eventRepository.save(eventEntity);
 	    
 	    //eventEntity.getParents().add(parententity);
    	}
    	 else 
    		 System.out.println(" id is not exist ");
    	
			
	}*/
	   @Transactional
	public void parentJoinEvent(Long idEvent,  Long id) {
		
    	  
    	if   
    	    ( parentRepository.findById(id).isPresent())
    	{
    	 Parent parententity =   parentRepository.findById(id).get();
    	 
    	 Event    eventEntity = eventRepository.findById(idEvent).get();
    	 Cagnotte c = cagnotteRepository.findById(eventEntity.getCagnotte().getIdCagnotte()).get() ;
    	 c.setTotalAmount(c.getTotalAmount()+eventEntity.getJackpotDonation());
    	 cagnotteRepository.save(c);
 	    eventEntity.getParents().add(parententity);
    	}
    	 else 
    		 System.out.println(" id is not exist ");
    	
			
	}

 /*    @Transactional
	public void cancelUserAttendance(Long idEvent,  Long id) {
		 
			Parent parentEntity= parentRepository.findById(id).get();
			
			Event    eventEntity = eventRepository.findById(idEvent).get();
			
			parentEntity.getEvents().remove( eventEntity);
			//parentRepository.save(parentEntity);
			
			eventRepository.save(eventEntity);
		
	}
*/
     @Transactional
	public void AffecterCagnotteAEvent(String idCagnotte, String idEvent) {
		
		  Cagnotte cagnotteEntity = cagnotteRepository.findById(Long.parseLong(idCagnotte)).get();
		
		  Event    eventEntity = eventRepository.findById(Long.parseLong(idEvent)).get();
		  
		  
		  eventEntity.setCagnotte(cagnotteEntity);
		  
		  eventRepository.save(eventEntity);
		
	}

   @Override
 	public Map<String, String> getNbrParticipants(Long idEvent) {
 		HashMap<String, String> map = new HashMap<>();
 		Optional<Event> ev = retrieveEvents(idEvent+"");
 		if (ev.isPresent()){
 			long nbParticipants= eventRepository.getNbrParticipants(idEvent);
 			double totalCagnotte = ev.get().getCagnotte().getTotalAmount()*nbParticipants ;
 			map.put("Nombre des participants", nbParticipants+"");
 			map.put("Total cagnotte", ev.get().getCagnotte().getTotalAmount()+"");
 			return map;
 		}
 		return map ;
 	}

       @Override
 	public Map<String, Object> getMaxCagnotte() {
 		HashMap<String, Object> map = new HashMap<>();
 		List<Event> events = retrieveAllEvents();
 		Event event = new Event();
 		double max=0 ;
 		double totalCagnotte=0 ;
 		long nbParticipants = 0 ;
 		for(Event e:events){ 			
 		nbParticipants= eventRepository.getNbrParticipants(e.getidEvent());
 			totalCagnotte = nbParticipants*e.getCagnotte().getTotalAmount() ;
 			System.out.println("totalCagnotte"+totalCagnotte);
 			if (totalCagnotte>max){
 				max = totalCagnotte ;
 				event=e ;
 			} 		
 		}
 		
 		map.put("Event", event);
		map.put("Max cagnotte", max+"");
 		return map ;
 	}

       @Transactional
	public void KinderGartenJoinEvent(Long idEvent, Long id) {
		if   
	    ( kindergartenRepository.findById(id).isPresent())
	{
	 KinderGarden kindergartenentity =  kindergartenRepository.findById(id).get();
	 
	 Event    eventEntity = eventRepository.findById(idEvent).get();
	    
	    eventEntity.getKindergartens().add(kindergartenentity);
	    //eventRepository.save(eventEntity);
	}
	 else 
		 System.out.println(" id is not exist ");
		
}
       
	@Override
	public Event findEventByName(String name) {
		
		return eventRepository.findEventByName(name);
	}

	@Override
	public Event findbyId(long  id) {
		// TODO Auto-generated method stub
		return eventRepository.findById(id).get();
	}
	//Resultat Events List between Two Dates
	
	public String ResultEvent(List<Event> events,int i) {
		return "Event "+i+""+"Name: "+events.get(i).getName()+
				""+"--Description: "+events.get(i).getDescription()+
				""+"--Location: "+events.get(i).getLocation()+
				""+"--startHour: "+events.get(i).getStartHour() +
				""+"--EndHour: "+events.get(i).getEndHour() +
				""+"--Date: "+events.get(i).getDate()+
				""+"--nbrlike: "+events.get(i).getNbrlike() +
				""+"--JackpotDonations: "+events.get(i).getJackpotDonation()+
				""+"--Subject: "+events.get(i).getSubject() ;
	}
	
	
	@Override
	public List<String> getEventTwoDatesBeetween(Date date1, Date date2) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		List<Event>events = (List<Event>) eventRepository.findAll();
		List<String>results = new ArrayList<>();
		
		if(date1.after(date2)) {
			return null;
		}
		
		for(int i = 0 ; i<events.size();i++) {
			if((events.get(i).getDate().after(date1) &&( events.get(i).getDate().before(date2)))) {
				results.add(ResultEvent(events,i));
			}
			
		}
		if(results.isEmpty()) {
			 results.add("Event Not Found between two dates :( :( ");
			 return results;
		}
		return results;
	}
	
	
	public List<Event> filterByCategory(CategoryEvent category) {
		return eventRepository.filterByCategory(category);
	}
	
	
	@Override
	public String affecterCategoryEvent(String category, long idEvent) {
		Event event = eventRepository.findById((long) idEvent).get();
		String msg=" ";
		
		//bch n7awl men string l enum => CategoryEvent.valueOf(category)
		try {
		for(CategoryEvent c : CategoryEvent.values()) {
			if(c == CategoryEvent.valueOf(category)) {
				event.setCategory(CategoryEvent.valueOf(category));
				eventRepository.save(event);
				return msg ="success :) ";
			}
		}
	}catch(Exception e) {
			 msg="failure :(";
		}
		return msg;
	}

	
}

		 
		  



	
	
		
	

	
	
	





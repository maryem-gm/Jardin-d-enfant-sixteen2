package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.esprit.project.entity.KinderGarden;
import com.esprit.project.repository.KinderGardenRepository;



@Service
public class KinderGardenServiceImpl implements IKinderGardenService{
	
	
	@Autowired
	private KinderGardenRepository kinderGardenRepository;
	
	private static final Logger l = LogManager.getLogger(KinderGardenServiceImpl.class);
	
	@Override
	public List<KinderGarden> retrieveAllKinderGardens(){
		List<KinderGarden> kinderGardens = (List<KinderGarden>) kinderGardenRepository.findAll();
		for (KinderGarden kinderGarden : kinderGardens){
			l.info("KinderGarden :" + kinderGarden);
		}
		return kinderGardens;
	}
	@Override
	public KinderGarden addKinderGarden(KinderGarden kinderGarden){
		return kinderGardenRepository.save(kinderGarden);
		
	}
	@Override
	public void deleteKinderGarden(String id){
		long id1 = Long.parseLong(id);
		kinderGardenRepository.deleteById(id1);
	}
	@Override
	public KinderGarden updateKinderGarden(KinderGarden kinderGarden){
		return kinderGardenRepository.save(kinderGarden);
	}
	@Override
	public Optional<KinderGarden> retrieveKinderGarden(String id){
		Optional<KinderGarden> kinderGarden = kinderGardenRepository.findById(Long.parseLong(id));
		l.info("KinderGarden :" + kinderGarden);
		return kinderGarden;
	}
	public KinderGarden findById(Long id) {
		Optional<KinderGarden> result = kinderGardenRepository.findById(id);
		KinderGarden kinderGarden = null;
		
		if(result.isPresent()) {
			kinderGarden = result.get();
		}
		else {
			return kinderGarden;
		}
		return kinderGarden;
	}
}

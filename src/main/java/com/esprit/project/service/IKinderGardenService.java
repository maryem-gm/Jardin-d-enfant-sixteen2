package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

//import com.esprit.project.entity.Administrator;
import com.esprit.project.entity.KinderGarden;






public interface IKinderGardenService {

	List<KinderGarden> retrieveAllKinderGardens();
	KinderGarden addKinderGarden(KinderGarden kinderGarden);
	void deleteKinderGarden(String id);
	KinderGarden updateKinderGarden(KinderGarden kinderGarden);
	Optional<KinderGarden> retrieveKinderGarden(String id);
}

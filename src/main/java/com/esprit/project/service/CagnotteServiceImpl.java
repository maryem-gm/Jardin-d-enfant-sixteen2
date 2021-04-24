package com.esprit.project.service;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Cagnotte;

import com.esprit.project.repository.CagnotteRepository;



@Service
public class CagnotteServiceImpl implements ICagnotteService {
	@Autowired
	CagnotteRepository cagnotterepository;
	private static final Logger L = LogManager.getLogger(CagnotteServiceImpl.class);

	@Override
	public Cagnotte save(Cagnotte cagnotte) {
		
		return cagnotterepository.save(cagnotte);
	}


	@Override
	public void deleteById(long idCagnotte) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Cagnotte> retrieveAllCagnotte() {
		List<Cagnotte> Cagnottes = (List<Cagnotte>) cagnotterepository.findAll();
		for (Cagnotte cagnotte : Cagnottes){
			L.info("cagnotte +++ : " + cagnotte);
		}
		return   Cagnottes ;
	}
	

}

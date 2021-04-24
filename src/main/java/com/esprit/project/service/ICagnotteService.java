package com.esprit.project.service;

import java.util.List;


import com.esprit.project.entity.Cagnotte;

public interface ICagnotteService {

	
	 public Cagnotte save(Cagnotte  cagnotte );
	 public List<Cagnotte>   retrieveAllCagnotte();
	 public void deleteById(long idCagnotte);

}

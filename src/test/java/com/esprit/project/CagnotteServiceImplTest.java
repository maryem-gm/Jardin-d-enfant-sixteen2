package com.esprit.project;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.project.entity.Cagnotte;

import com.esprit.project.service.ICagnotteService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CagnotteServiceImplTest {
	@Autowired 
	ICagnotteService cs;
	
	
	@Test
	public void testAddCagnotte() {
	
	Cagnotte  C = new Cagnotte((long) 3 , 500.0);
	cs.save(C);
	}
	@Test
	public void testretrieveCagnottes(){
		cs.retrieveAllCagnotte();
	}

}

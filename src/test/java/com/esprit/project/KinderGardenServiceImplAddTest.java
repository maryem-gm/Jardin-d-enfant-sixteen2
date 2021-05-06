package com.esprit.project;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.project.entity.KinderGarden;
import com.esprit.project.entity.Parent;
//import com.esprit.project.entity.Parent;
import com.esprit.project.service.IKinderGardenService;
//import com.esprit.project.service.IParentService;
//import com.esprit.project.service.ParentServiceImpl;
import com.sun.el.parser.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KinderGardenServiceImplAddTest {
	
	//private static final Logger l = LogManager.getLogger(ParentServiceImpl.class);
	@Autowired 
	IKinderGardenService kinderGarden;
	
	/*@Test
	public void test() throws ParseException, java.text.ParseException {
		KinderGarden kinderGarden1 = new KinderGarden(1, "kids", "study",93147141, "kidsstydy@esprit.tn", "kairouan",10);
		kinderGarden.addKinderGarden(kinderGarden1);
		
		KinderGarden kinderGarden2 = new KinderGarden(1, "jouri", "kids",93147141, "jourikids@esprit.tn", "tunis",10);
		kinderGarden.addKinderGarden(kinderGarden2);
		
		
	
		
	}
*/
}

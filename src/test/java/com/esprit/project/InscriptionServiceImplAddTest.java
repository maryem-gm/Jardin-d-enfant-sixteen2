package com.esprit.project;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import com.esprit.project.entity.Administrator;
import com.esprit.project.entity.Inscription;
//import com.esprit.project.service.AccountServiceImpl;
//import com.esprit.project.service.AdministratorServiceImpl;
//import com.esprit.project.service.IAdministratorService;
import com.esprit.project.service.IInscriptionService;
import com.sun.el.parser.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InscriptionServiceImplAddTest {
	
	//private static final Logger l = LogManager.getLogger(AdministratorServiceImpl.class);
	@Autowired 
	IInscriptionService inscriptionrepo;
	
	@Test
	public void test() throws ParseException, java.text.ParseException {
		Inscription inscription = new Inscription(1,"active");
		inscriptionrepo.addInscription(inscription);
		
		Inscription inscription1 = new Inscription(2,"active");
		inscriptionrepo.addInscription(inscription1);
		Inscription inscription2 = new Inscription(3,"active");
		inscriptionrepo.addInscription(inscription2);
		Inscription inscription3 = new Inscription(4,"active");
		inscriptionrepo.addInscription(inscription3);
		Inscription inscription4 = new Inscription(5,"active");
		inscriptionrepo.addInscription(inscription4);
	}

}

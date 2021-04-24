package com.esprit.project.control;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Mail;
import com.esprit.project.service.IGestionMailing;
import org.springframework.web.bind.annotation.RequestBody;

/*import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;*/


@RestController
public class EmailRestController {
	
	@Autowired 
	IGestionMailing gestionMailing;
	
	/*// http://localhost:8081/SpringMVC/servlet/retrieve-all-emails
	@GetMapping("/retrieve-all-emails")
	@ResponseBody
	public List<Mail> getEmails() {
	List<Mail> list = gestionMailing.retrieveAllEmails();
	return list;
	}
	
	// http://localhost:8081/retrieve-email/{email-id}
	@GetMapping("/retrieve-email/{email-id}")
	@ResponseBody
	public Optional<Mail> retrieveEmail(@PathVariable("email-id") String idMail) {
	return gestionMailing.retrieveEmail(idMail);
	}*/
	
	
	// http://localhost:8081/SpringMVC/servlet/sendingemail
	@PostMapping("/sendingemail")
	@ResponseBody
	  public ResponseEntity<?> sendEmail(@RequestBody Mail request)
    {

        System.out.println(request);


        boolean result = this.gestionMailing.sendEmail(request.getSubject(), request.getMessage(), request.getTo());

        if(result){

            return  ResponseEntity.ok("Email Properly Sent Successfully... ");

        }else{

            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email sending fail");
        }
    }
	
	// http://localhost:8081/SpringMVC/servlet/sendingemailattachement
		 @PostMapping("/sendingemailattachement")
		 @ResponseBody
		    public ResponseEntity<?> sendEmailWithAttachment(@RequestBody Mail request)
		    {
		        System.out.println(request);

		        boolean result = this.gestionMailing.sendWithAttachment(request.getSubject(), request.getMessage(), request.getTo());

		        if(result){

		            return  ResponseEntity.ok("Sent Email With Attchment Successfully... ");

		        }else{

		            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("attachment email sending fail");
		        }

		    }
}

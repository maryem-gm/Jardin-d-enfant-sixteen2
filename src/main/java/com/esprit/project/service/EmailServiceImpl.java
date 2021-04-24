package com.esprit.project.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Mail;
import com.esprit.project.repository.MailRespository;

//import java.util.List;
//import java.util.Optional;
import java.util.Properties;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



@Service
public class EmailServiceImpl implements IGestionMailing{
	
	@Autowired
	MailRespository emailRepository;
	
	//private static final Logger l = LogManager.getLogger(EmailServiceImpl.class);


	public boolean sendEmail(String subject, String message, String to)
    {
        boolean foo = false; // Set the false, default variable "foo", we will allow it after sending code process email

        String senderEmail = "jouinisinda7@gmail.com"; // your gmail email id
        String senderPassword = "sinda1997"; // your gmail id password

        // Properties class enables us to connect to the host SMTP server
        Properties properties = new Properties();

        // Setting necessary information for object property

        // Setup host and mail server
        properties.put("mail.smtp.auth", "true"); // enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // enable TLS-protected connection
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Mention the SMTP server address. Here Gmail's SMTP server is being used to send email
        properties.put("mail.smtp.port", "587"); // 587 is TLS port number
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // get the session object and pass username and password
        Session session = Session.getDefaultInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){

                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {

            MimeMessage msg = new MimeMessage(session); // Create a default MimeMessage object for compose the message

            msg.setFrom(new InternetAddress(senderEmail)); // adding sender email id to msg object

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // adding recipient to msg object

            msg.setSubject(subject); // adding subject to msg object
            msg.setText(message); // adding text to msg object

            Transport.send(msg); // Transport class send the message using send() method
            System.out.println("Email Sent Successfully...");

            foo = true; // Set the "foo" variable to true after successfully sending emails

        }catch(Exception e){

            System.out.println("EmailService File Error"+ e);
        }

        return foo; // and return foo variable
    }
    

	public boolean sendWithAttachment(String subject, String message, String to)
    {
        boolean foo = false; // Set the false, default variable "foo", we will allow it after sending code process email

        String senderEmail = "jouinisinda7@gmail.com"; // your gmail email id
        String senderPassword = "sinda1997"; // your gmail id password

        //Properties class enables us to connect to the host SMTP server
        Properties properties = new Properties();

        //Setting necessary information for object property

        //Setup host and mail server
        properties.put("mail.smtp.auth", "true"); // enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // enable TLS-protected connection
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Mention the SMTP server address. Here Gmail's SMTP server is being used to send email
        properties.put("mail.smtp.port", "587"); // 587 is TLS port number
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // get the session object and pass username and password
        Session session = Session.getDefaultInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){

                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {

            MimeMessage msg = new MimeMessage(session); // Create a default MimeMessage object for compose the message

            msg.setFrom(new InternetAddress(senderEmail)); // adding sender email id to msg object

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // adding recipient to msg object

            msg.setSubject(subject); // adding subject to msg object

            // sets file location
            String path = "C:\\Users\\jouin\\Desktop\\donnee.pdf";

            MimeMultipart mimeMultipart = new MimeMultipart(); // create MimeMultipart object

            MimeBodyPart textMime = new MimeBodyPart(); // create first MimeBodyPart object textMime for containing the message

            MimeBodyPart fileMime = new MimeBodyPart(); //create second MimeBodyPart object fileMime for containing the file

            textMime.setText(message); //sets message to textMime object

            File file = new File(path); //Initialize the File and Move Path variable
            fileMime.attachFile(file); //attach file to fileMime object

            //The mimeMmultipart adds textMime and fileMime to the
            mimeMultipart.addBodyPart(textMime);
            mimeMultipart.addBodyPart(fileMime);

            msg.setContent(mimeMultipart); // Sets the mimeMultipart the contents of the msg

            Transport.send(msg); // Transport class send the message using send() method
            System.out.println("Email Sent With Attachment Successfully...");

            foo = true; // Set the "foo" variable to true after successfully sending emails with attchment

        }catch(Exception e){

            System.out.println("EmailService File Error"+ e);
        }

        return foo; // and return foo variable
    }
    
    
   /* @Override
	public List<Mail> retrieveAllEmails() {
		List<Mail> emails = (List<Mail>) emailRepository.findAll();
		for (Mail email : emails){
			l.info("Email :" + email);
		}
		return emails;
		}

	@Override
	public Optional<Mail> retrieveEmail(String id) {
		Optional<Mail> email = emailRepository.findById(Long.parseLong(id));
		l.info("email :" + email);
		return email;
	}*/



}

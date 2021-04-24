package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Mail;

public interface IGestionMailing {
	
	public boolean sendWithAttachment(String subject, String message, String to);
	public boolean sendEmail(String subject, String message, String to);
	/*List<Mail> retrieveAllEmails();
	Optional<Mail> retrieveEmail(String id);*/


	
}

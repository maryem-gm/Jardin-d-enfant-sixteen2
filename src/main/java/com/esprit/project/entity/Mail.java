package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "T_Mail")
public class Mail implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private long idMail;

	@Column(name="sendto")
	private String to;

	@Column(name="subject")
	private String Subject;
	
	@Column(name="message")
	private String message;
	

	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



	public Mail(long idMail, String to, String subject, String message) {
		super();
		this.idMail = idMail;
		this.to = to;
		Subject = subject;
		this.message = message;
	}





	public long getIdMail() {
		return idMail;
	}





	public void setIdMail(long idMail) {
		this.idMail = idMail;
	}





	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getSubject() {
		return Subject;
	}


	public void setSubject(String subject) {
		Subject = subject;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	


	


	
	
	
	
	
}


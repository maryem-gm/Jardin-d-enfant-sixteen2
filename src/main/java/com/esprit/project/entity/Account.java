package com.esprit.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="T_ACCOUNT")
public class Account implements Serializable {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="Account_Login")
	private String login;
	
	@Column(name="Account_Password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	ERole role;
	
	@ManyToOne
	Administrator administrator;
	
	@OneToOne
	private User user;
	
	public Account(){
		
	}
	
	public Account(long id, String login, String password, ERole role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}
	
	public String toString(){
		return "account : "+ "  id  "+ id +"  login  "+ login +"  password  "+password +"  Role  "+role;
	}
	
}

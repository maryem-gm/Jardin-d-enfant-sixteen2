package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_Profile")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Number_Childs")
	private int numberchilds;
	
	@Temporal(TemporalType.DATE)
	private Date datecreaction;
	
	@Column(name="Phone_Number")
	private int phone;
	
	@Column(name="Adress")
	@Enumerated(EnumType.STRING)
	private Adresse adress;

	@Column(name="Location")
	private String location;
	
	@Column(name="Preference")
	@Enumerated(EnumType.STRING)
	private Preference prefernce;
	
	@Column(name="Profession")
	@Enumerated(EnumType.STRING)
	private Profession profession;

	@OneToOne
	private User user;
	
	public Profile(){
		
	}
	public Profile(long id, int numberchilds, Date datecreaction, int phone, Adresse adress, String location) {
		super();
		this.id = id;
		this.numberchilds = numberchilds;
		this.datecreaction = datecreaction;
		this.phone = phone;
		this.adress = adress;
		this.location = location;
	}
	
	

	public Profile(long id, int numberchilds, Date datecreaction, int phone, Adresse adress, String location,
			Preference preferncer) {
		super();
		this.id = id;
		this.numberchilds = numberchilds;
		this.datecreaction = datecreaction;
		this.phone = phone;
		this.adress = adress;
		this.location = location;
		this.prefernce = prefernce;
	}
	public Profile(long id, int numberchilds, Date datecreaction, int phone, Adresse adress, String location,
			Preference prefernce, Profession profession) {
		super();
		this.id = id;
		this.numberchilds = numberchilds;
		this.datecreaction = datecreaction;
		this.phone = phone;
		this.adress = adress;
		this.location = location;
		this.prefernce = prefernce;
		this.profession = profession;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumberchilds() {
		return numberchilds;
	}

	public void setNumberchilds(int numberchilds) {
		this.numberchilds = numberchilds;
	}

	public Date getDatecreaction() {
		return datecreaction;
	}

	public void setDatecreaction(Date datecreaction) {
		this.datecreaction = datecreaction;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Adresse getAdress() {
		return adress;
	}

	public void setAdress(Adresse adress) {
		this.adress = adress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public Preference getPrefernce() {
		return prefernce;
	}
	public void setPrefernce(Preference prefernce) {
		this.prefernce = prefernce;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String toString(){
		return "id :" +id +"phone :" +phone+"adress :" +adress+"prefernce :" +prefernce +"profession"+profession;
		
	}

	
}

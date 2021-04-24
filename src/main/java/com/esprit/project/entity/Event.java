package com.esprit.project.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
//import java.util.Set;
//import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinTable;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table( name = "T_Events")
//@JsonIgnoreProperties(  "Parents" )
//@JsonIgnoreProperties(  "kindergartens" )

public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	 private Long  idEvent;
	@Column(name="Subject")
	 private String Subject;
	@Column(name="Description")
	 private String Description;
	@Column(name="heure_debut")
	 private int startHour;
	@Column(name="heure_fin")
	 private int  EndHour;
	@JsonFormat(pattern = "MM/dd/yyyy hh:mm:ss")
	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	 private Date  date;
	@Column(name="nombre_like")
	private int  nbrlike ;
	@Column(name="Name")
	private String Name;
	@Column(name="Location")
	private String Location;
	@Column(name="JackpotDonation")
	private float JackpotDonation;
	@Enumerated(EnumType.STRING)
	private CategoryEvent category;

	@OneToMany(mappedBy="event", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Comment> comments;
	
	

	
	@ManyToMany( cascade=  CascadeType.ALL )
	@JsonIgnore
	private List<Parent> parents;

	
	
	@ManyToMany( cascade=  CascadeType.ALL )
	@JsonIgnore
	private List<KinderGarden> kindergartens;
	
	
	//@JsonBackReference
	@OneToOne
	private Cagnotte cagnotte;

	
	public Long getidEvent() {
		return idEvent;
	}
	public void setidEvent(Long idEvent) {
		this.idEvent = idEvent;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNbrlike() {
		return nbrlike;
	}
	public void setNbrlike(int nbrlike) {
		this.nbrlike = nbrlike;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getEndHour() {
		return EndHour;
	}
	public void setEndHour(int endHour) {
		EndHour = endHour;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}

	public float getJackpotDonation() {
		return JackpotDonation;
	}
	public void setJackpotDonation(float JackpotDonation) {
		this.JackpotDonation = JackpotDonation;
	}
	public Event(Long idEvent, String subject, String description, int startHour, int endHour, Date date, int nbrlike,
			String name, String location, float JackpotDonation, CategoryEvent category) {
		
		this.idEvent = idEvent;
		this.Subject = subject;
		this.Description = description;
		this.startHour = startHour;
		this.EndHour = endHour;
		this.date = date;
		this.nbrlike = nbrlike;
		this.Name = name;
		this.Location = location;
		this.JackpotDonation = JackpotDonation ;
		this.category = category;
	}

    
    public Event() {
		
	}
	
	
	public Event(long idEvent, String subject, String description, int startHour, int endHour, Date date, int nbrlike, String name, String location, float JackpotDonation, CategoryEvent category ) {
		this.idEvent = idEvent;
		this.Subject = subject;
		this.Description = description;
		this.startHour = startHour;
		this.EndHour = endHour;
		this.date = date;
		this.nbrlike = nbrlike;
		this.Name = name;
		this.Location = location;
		this.JackpotDonation = JackpotDonation ;
		this.category = category;
	}

	

	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
	public List<Parent> getParents() {
		return parents;
	}
	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}
	public Cagnotte getCagnotte() {
		return cagnotte;
	}
	public void setCagnotte(Cagnotte cagnotte) {
		this.cagnotte = cagnotte;
	}
	
	
	
	

	public List<KinderGarden> getKindergartens() {
		return kindergartens;
	}
	public void setKindergartens(List<KinderGarden> kindergartens) {
		this.kindergartens = kindergartens;
	}
	
	@Override
	public String toString() {
		return "Event [idEvent=" + idEvent + ", Subject=" + Subject + ", Description=" + Description + ", startHour="
				+ startHour + ", EndHour=" + EndHour + ", date=" + date + ", nbrlike=" + nbrlike + ", Name=" + Name
				+ ", Location=" + Location + ", JackpotDonation=" + JackpotDonation + ", category=" + category + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + EndHour;
		result = prime * result + ((Location == null) ? 0 : Location.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Subject == null) ? 0 : Subject.hashCode());
		result = prime * result + ((cagnotte == null) ? 0 : cagnotte.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + Float.floatToIntBits(JackpotDonation);
		result = prime * result + ((idEvent == null) ? 0 : idEvent.hashCode());
		result = prime * result + nbrlike;
		result = prime * result + startHour;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (EndHour != other.EndHour)
			return false;
		if (Location == null) {
			if (other.Location != null)
				return false;
		} else if (!Location.equals(other.Location))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Subject == null) {
			if (other.Subject != null)
				return false;
		} else if (!Subject.equals(other.Subject))
			return false;
		if (cagnotte == null) {
			if (other.cagnotte != null)
				return false;
		} else if (!cagnotte.equals(other.cagnotte))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Float.floatToIntBits(JackpotDonation) != Float.floatToIntBits(other.JackpotDonation))
			return false;
		if (idEvent == null) {
			if (other.idEvent != null)
				return false;
		} else if (!idEvent.equals(other.idEvent))
			return false;
		if (nbrlike != other.nbrlike)
			return false;
		if (startHour != other.startHour)
			return false;
		return true;
	}
	public CategoryEvent getCategory() {
		return category;
	}
	public void setCategory(CategoryEvent category) {
		this.category = category;
	}
	

	}

	
	 

	


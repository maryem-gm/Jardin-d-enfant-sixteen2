package com.esprit.project.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_KinderGarden")
@PrimaryKeyJoinColumn(name = "id")

public class KinderGarden extends User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="kinderGarden")
	private Set<Reclamation> reclamations = new HashSet<>();
	@Column(name="reclamation_nbr")
	private int reclamation_nbr;
	@Column(name="isBlocked")
	private boolean isBlocked = false;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Visitor> visitors;
	

	@OneToMany(mappedBy="kinderGarden",cascade=CascadeType.ALL)
	//@JoinColumn(name = "id_kinderGarden")
	private List<Rdv> rdvs;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kinderGarden")
	private Set<Inscription> inscriptions;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kindergarten")
	private Set<Parent> parents;
	
	/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	 private List<Offre> offres;*/
	
	@ManyToMany(mappedBy = "kindergartens",  cascade =   CascadeType.ALL )
    private 	List<Event>  Events;
	
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set<Reclamation> getReclamations() {
		return reclamations;
	}
	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}
	public int getReclamation_nbr() {
		return reclamation_nbr;
	}
	public void setReclamation_nbr(int reclamation_nbr) {
		this.reclamation_nbr = reclamation_nbr;
	}
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	public KinderGarden() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KinderGarden(Long id, @NotBlank @Size(max = 20) String username,
			@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password, String firstName,
			String lastName, int phone, String adress, Set<Role> roles) {
		super(id, username, email, password, firstName, lastName, phone, adress, roles);
		// TODO Auto-generated constructor stub
	}
	public KinderGarden(String string, String string2, int i, String string3, String string4) {
		super(string, string2, i, string3, string4);
		// TODO Auto-generated constructor stub
	}
	public KinderGarden(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, String firstName, String lastName, int phone, String adress) {
		super(username, email, password, firstName, lastName, phone, adress);
		// TODO Auto-generated constructor stub
	}
	public KinderGarden(String username, String email, String password) {
		super(username, email, password);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KinderGarden [id=" + id + "]";
	}
	public Set<Visitor> getVisitors() {
		return visitors;
	}
	public void setVisitors(Set<Visitor> visitors) {
		this.visitors = visitors;
	}
	public List<Rdv> getRdvs() {
		return rdvs;
	}
	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}
	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	public Set<Parent> getParents() {
		return parents;
	}
	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}
/*	public List<Offre> getOffres() {
		return offres;
	}
	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}*/
	public List<Event> getEvents() {
		return Events;
	}
	public void setEvents(List<Event> events) {
		Events = events;
	}
	
	
}

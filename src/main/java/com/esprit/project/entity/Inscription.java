package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="T_Inscription")
public class Inscription implements Serializable {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="Status")
	private String status;

	@ManyToOne
	KinderGarden kinderGarden;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="inscription")
	private Set<Parent> parents;
	
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inscription(long id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public KinderGarden getKinderGarden() {
		return kinderGarden;
	}

	public void setKinderGarden(KinderGarden kinderGarden) {
		this.kinderGarden = kinderGarden;
	}

	public Set<Parent> getParents() {
		return parents;
	}

	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}

	public String toString(){
		return "  id  "+ id +"  statut  "+ status;

	}	
}

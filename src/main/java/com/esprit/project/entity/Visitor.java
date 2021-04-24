package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="T_Visitor")
public class Visitor implements Serializable {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany(mappedBy="visitors", cascade = CascadeType.ALL)
	private Set<KinderGarden> kinderGardens;

	public Visitor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Visitor(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String toString(){
		return "  visitor:  id:  " + id;
	}

	
}

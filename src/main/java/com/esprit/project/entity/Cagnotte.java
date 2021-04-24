package com.esprit.project.entity;

//import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;





@Entity
@Table(name="Cagnotte")
public class Cagnotte {
	
	@Id
	@GeneratedValue
	private Long idCagnotte;
	@Column(name="TotalAmount")
	private double TotalAmount;
	
	
	public double getTotalAmount() {
		return TotalAmount;
	}




	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}




	public Cagnotte(Long idCagnotte, double d) {
		super();
		this.idCagnotte = idCagnotte;
		TotalAmount = d;
	}
	
	

	
	public Cagnotte() {
		super();
		// TODO Auto-generated constructor stub
	}
     
	
	@OneToOne (cascade = { CascadeType.ALL }, mappedBy = "cagnotte")
	//@JsonManagedReference
	@JsonIgnore
	private Event event;
	//@JsonIgnore
	/*@ManyToMany(cascade = CascadeType.ALL)
	private List<Parent> cagnotteparents;*/
	
	
/*	public List<Parent> getCagnotteparents() {
		return cagnotteparents;
	}
	public void setCagnotteparents(List<Parent> cagnotteparents) {
		this.cagnotteparents = cagnotteparents;
	}*/
	
	




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(TotalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((idCagnotte == null) ? 0 : idCagnotte.hashCode());
		return result;
	}




	public Long getIdCagnotte() {
		return idCagnotte;
	}




	public void setIdCagnotte(Long idCagnotte) {
		this.idCagnotte = idCagnotte;
	}




	public Event getEvent() {
		return event;
	}




	public void setEvent(Event event) {
		this.event = event;
	}




	@Override
	public String toString() {
		return "Cagnotte [idCagnotte=" + idCagnotte + ", TotalAmount=" + TotalAmount + "]";
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cagnotte other = (Cagnotte) obj;
		if (Double.doubleToLongBits(TotalAmount) != Double.doubleToLongBits(other.TotalAmount))
			return false;
		if (idCagnotte == null) {
			if (other.idCagnotte != null)
				return false;
		} else if (!idCagnotte.equals(other.idCagnotte))
			return false;
		return true;
	}

	
	
	
	
	
	
}

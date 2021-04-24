package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="T_Offre")


public class Offre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String prix;
	@Enumerated(EnumType.STRING)
	private TypeOffre typeOffre; 
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;
	@Column(name="DESCRIPTION")
	private String description;
	

	public Offre(String description) {
		super();
		this.description = description;
	}
	
	//@Jsonignore
	@ManyToOne
	private KinderGarden kindergardens;
	
	@ManyToMany(mappedBy="OffreParent", cascade = CascadeType.ALL)
	private List<Parent> parents;
	
	public Offre(long id, String prix, TypeOffre typeOffre, Date dateDebut, Date dateFin, String description) {
		super();
		this.id = id;
		this.prix = prix;
		this.typeOffre = typeOffre;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
	}
	public Offre() {
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	
	public TypeOffre getTypeOffre() {
		return typeOffre;
	}
	public void setTypeOffre(TypeOffre typeOffre) {
		this.typeOffre = typeOffre;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	/*public Offre(long id, String prix, TypeOffre typeOffre, Date dateDebut, Date dateFin, KinderGarden kindergardens,
			Set<Parent> parents) {
		super();
		this.id = id;
		this.prix = prix;
		this.typeOffre = typeOffre;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.kindergardens = kindergardens;
		Parents = parents;
	}
	*/
	
	
	/*public Offre(long l, String prix, TypeOffre typeOffre, Date dateDebut, Date dateFin) {
		this.id=l;
		this.prix=prix;
		this.typeOffre=typeOffre;
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
	}
	*/
	
	
	
	
	@Override
	public String toString() {
		return "Offre [id=" + id + ", prix=" + prix + ", typeOffre=" + typeOffre + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", description=" + description +"]";
	}
	public KinderGarden getKindergardens() {
		return kindergardens;
	}
	public void setKindergardens(KinderGarden kindergardens) {
		this.kindergardens = kindergardens;
	}
	public List<Parent> getParents() {
		return parents;
	}
	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}
	
	
	

}

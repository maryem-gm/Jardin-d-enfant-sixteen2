package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "T_Rdv")
public class Rdv implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private long idRdv;
	public long getIdRdv() {
		return idRdv;
	}
	public void setIdRdv(int idRdv) {
		this.idRdv = idRdv;
	}

	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="Subject")
	 private String Subject;
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}

	@ManyToOne
	@JoinColumn(name = "id_parent")
	private Parent parent;
	@ManyToOne
	@JoinColumn(name = "id_kinderGarden")
	private KinderGarden kinderGarden;
	public Rdv() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Rdv [idRdv=" + idRdv + ", date=" + date + ", Subject=" + Subject + ", parent="
				+ parent + ", kinderGarden=" + kinderGarden + "]";
	}
	public Rdv(long idRdv, Date date, String subject, Parent parent, KinderGarden kinderGarden) {
		super();
		this.idRdv = idRdv;
		this.date = date;
		Subject = subject;
		this.parent = parent;
		this.kinderGarden = kinderGarden;
	}
	


	
	
	
	
	
}

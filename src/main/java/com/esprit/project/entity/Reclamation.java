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
	@Table(name = "T_Reclamation")
	public class Reclamation implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue ( strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name="Subject")
		private String subject;
		@Column(name="Description")
		private String description;
		@Column(name= "categoryOfReclamation")
		private String categoryOfReclamation;
		@Column(name= "statusOfReclamation")
		private statusOfReclamation status=statusOfReclamation.Processing;
		@Column(name="senderReclamation")
		private String senderReclamation;

		@Temporal(TemporalType.TIMESTAMP)
		private Date creationTime = new Date();
		@ManyToOne
		@JoinColumn(name="kinderGarden_id") 
		private KinderGarden kinderGarden;
		@ManyToOne
		@JoinColumn(name="parent_id") 
		private Parent parent;


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCategoryOfReclamation() {
			return categoryOfReclamation;
		}

		public void setCategoryOfReclamation(String categoryOfReclamation) {
			this.categoryOfReclamation = categoryOfReclamation;
		}


		public statusOfReclamation getStatus() {
			return status;
		}

		public void setStatus(statusOfReclamation status) {
			this.status = status;
		}

		public String getSenderReclamation() {
			return senderReclamation;
		}

		public void setSenderReclamation(String senderReclamation) {
			this.senderReclamation = senderReclamation;
		}


		public Date getCreationTime() {
			return creationTime;
		}

		public void setCreationTime(Date creationTime) {
			this.creationTime = creationTime;
		}

		public KinderGarden getKinderGarden() {
			return kinderGarden;
		}

		public void setKinderGarden(KinderGarden kinderGarden) {
			this.kinderGarden = kinderGarden;
		}
		

		/*@Override
		public String toString() {
			return "Reclamation [id=" + id + ", subject=" + subject + ", description=" + description
					+ ", categoryOfReclamation=" + categoryOfReclamation + ", statusOfReclamation=" + statusOfReclamation
					+ ", senderReclamation=" + senderReclamation + ", date=" + date + ", kinderGarden=" + kinderGarden + "]";
		}*/

		/*public Parent getParent() {
			return parent;
		}

		public void setParent(Parent parent) {
			this.parent = parent;
		}*/

		public Reclamation(String subject, String description, String categoryOfReclamation, String senderReclamation,
				KinderGarden kinderGarden) {
			super();
			//this.id = id;
			this.subject = subject;
			this.description = description;
			this.categoryOfReclamation = categoryOfReclamation;
			//this.statusOfReclamation = statusOfReclamation;
			this.senderReclamation = senderReclamation;
			//this.date = date;
			this.kinderGarden = kinderGarden;
			//this.parent = parent;
		}

		public Reclamation() {
			super();
			// TODO Auto-generated constructor stub
		}



		

		
		
		
		
	}




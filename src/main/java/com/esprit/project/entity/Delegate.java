package com.esprit.project.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
@Table(name="T_Delegate")
@PrimaryKeyJoinColumn(name = "id")
public class Delegate extends Parent {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;

	public Delegate(){
		
	}

	public Delegate(long id) {
		super();
		this.id = id;
	}
	

	public Delegate(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, String firstName, String lastName, int phone, String adress,
			Set<Role> roles) {
		super(id, username, email, password, firstName, lastName, phone, adress, roles);
		// TODO Auto-generated constructor stub
	}

	public Delegate(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, String firstName, String lastName, int phone, String adress) {
		super(username, email, password, firstName, lastName, phone, adress);
		// TODO Auto-generated constructor stub
	}

	public Delegate(String username, String email, String password) {
		super(username, email, password);
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

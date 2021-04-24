package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "conversation")
public class Conversation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="conversation")
    private Set<Message> messages = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "user_conversations", joinColumns = @JoinColumn(name = "conversation_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id")) 
	private Set<User> users = new HashSet<>();
	
	
	public Conversation() {

	}


	
	

	public Conversation(Set<User> users) {
		super();
		this.users = users;
	}





	public Conversation(Set<Message> messages, Set<User> users) {
		super();
		this.messages = messages;
		this.users = users;
	}
	
	



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
	
	
}

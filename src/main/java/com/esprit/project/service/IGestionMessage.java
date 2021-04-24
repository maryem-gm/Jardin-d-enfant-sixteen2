package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Message;
//import com.esprit.project.entity.MessageKeyWord;
//import com.esprit.project.entity.Rdv;

public interface IGestionMessage {
	
	List<Message> retrieveAllMessages();
	Message addMessage(Message message);
	Optional<Message> retrieveMessage(String idMessage);
	String translate(String word);


}

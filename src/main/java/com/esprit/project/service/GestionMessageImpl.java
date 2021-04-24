package com.esprit.project.service;

//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.esprit.project.entity.Message;
//import com.esprit.project.repository.MessageKeyWordRepository;
import com.esprit.project.repository.MessageRepository;

import org.springframework.stereotype.Service;
//import com.esprit.project.service.IMessageSuggestionService;

@Service
public class GestionMessageImpl implements IGestionMessage{

	private static final Logger l = LogManager.getLogger(EmailServiceImpl.class);
	
	@Autowired 
	MessageRepository messageRepository;
		/// TEST


	 @Override
		public List<Message> retrieveAllMessages() {
			List<Message> messages = (List<Message>) messageRepository.findAll();
			for (Message message : messages){
				l.info("Message :" + message);
			}
			return messages;
			}

	@Override
	public Message addMessage(Message message) {
		return messageRepository.save(message);
	}
	
	@Override
	public Optional<Message> retrieveMessage(String idMessage) {
		Optional<Message> message = messageRepository.findById(Long.parseLong(idMessage));
		l.info("message :" + message);
			return message;
	}

	@Override
	public String translate(String word) {
		// TODO Auto-generated method stub
		return null;
	}


}

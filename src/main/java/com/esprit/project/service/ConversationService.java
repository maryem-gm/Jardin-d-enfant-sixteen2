package com.esprit.project.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Conversation;
import com.esprit.project.entity.Message;
//import com.esprit.project.entity.Rdv;
import com.esprit.project.entity.User;
import com.esprit.project.repository.ConversationRepository;
//import com.esprit.project.repository.UserRepository;
import com.esprit.project.repository.MessageRepository;

@Service
public class ConversationService {
	
	/*@Autowired
	private UserRepository userRepository;*/
	
	private static final Logger L = LogManager.getLogger(ConversationService.class);

	
	@Autowired
	private ConversationRepository conversationRepository;
	
	@Autowired
	private MessageRepository MessageRepository;
	
	@Autowired
	private UserServiceImpl userService;
	
	public Conversation findById(Long id) {
		Optional<Conversation> result = conversationRepository.findById(id);
		Conversation conversation = null;
		
		if(result.isPresent()) {
			conversation = result.get();
		}
		else {
			return conversation;
		}
		return conversation;
	}
	
	
	  public void store(Long userId, Long conv_id, Message text) throws IOException {
		  
		  Conversation conv = null;
		  
		  User user = userService.findById(userId); 
		  Set<Message> messages = new HashSet<>();
		  Set<User> users = new HashSet<>();
		  users.add(user);
		  if(findById(conv_id) == null) {
		  conv = new Conversation(users);
		  }else {
		  conv = findById(conv_id);
		  conv.setUsers(users);
		  //conv.setMessages(messages);
		  }
		  Conversation savedconv = conversationRepository.save(conv);
		  Message mess = new Message(text.getText(), conv);
		  MessageRepository.save(mess);
	  
	  }

		public List<Conversation> retrieveAllConversations() {
			List<Conversation> conversations = (List<Conversation>) conversationRepository.findAll();
			for (Conversation conversation : conversations){
				L.info("Conversation :" + conversation);
			}
			return conversations;
		}
}

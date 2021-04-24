package com.esprit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Conversation;


@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long>  {

}
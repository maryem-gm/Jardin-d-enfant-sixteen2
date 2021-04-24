package com.esprit.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Mail;

@Repository
public interface MailRespository extends CrudRepository<Mail, Long> {

}

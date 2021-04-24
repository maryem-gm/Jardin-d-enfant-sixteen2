package com.esprit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Reaction;
@Repository
public interface ReactionRepository extends JpaRepository<Reaction,Long> {

}

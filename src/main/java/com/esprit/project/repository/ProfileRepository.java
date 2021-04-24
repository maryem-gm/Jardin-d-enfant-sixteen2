package com.esprit.project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Adresse;
import com.esprit.project.entity.Preference;
import com.esprit.project.entity.Profile;






@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
	
	@Query("SELECT p FROM Profile p JOIN p.user u join u.roles r where r.id =3 AND p.adress= :adress")
	//@Query("SELECT p FROM Profile p JOIN User u WHERE u.role=ROLE_KINDERGARDEN AND p.adress= :adress")
	List<Profile> retrieveProfilePByAdress(@Param("adress") Adresse adresse);
	
	//@Query("SELECT p FROM Profile p WHERE p.adress= :adress")
	@Query("SELECT p FROM Profile p JOIN p.user u join u.roles r where r.id =2 AND p.adress= :adress")
	//@Query("SELECT p FROM Profile p JOIN User u WHERE u.role=ROLE_KINDERGARDEN AND p.adress= :adress")
	List<Profile> retrieveProfileKByAdress(@Param("adress") Adresse adresse);
	@Query("SELECT p FROM Profile p JOIN p.user u join u.roles r where r.id =3 AND p.prefernce= :prefernce")
	List<Profile> retrieveProfileByPreference(@Param("prefernce") Preference preferncee);
	
	@Query("SELECT p FROM Profile p JOIN p.user u join u.roles r where r.id =3 AND p.adress= :adress ORDER BY p.numberchilds DESC")
	List<Profile> retrieveCibleProfileByAdress(@Param("adress") Adresse adresse);
	
}

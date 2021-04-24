package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.esprit.project.entity.Adresse;
import com.esprit.project.entity.Preference;
//import com.esprit.project.entity.Administrator;
import com.esprit.project.entity.Profile;






public interface IProfileService {

	List<Profile> retrieveAllProfiles();
	Profile addProfile(Profile profile);
	void deleteProfile(String id);
	Profile updateProfile(Profile profile);
	Optional<Profile> retrieveProfile(String id);
	List<Profile> retrieveProfileKByAdress(Adresse adresse);
	List<Profile> retrieveProfileByPreference(Preference preferncee);
	List<Profile> retrieveCibleProfileByAdress(Adresse adresse);
	String StatPrefernce(Adresse adresse);
	List<Profile> retrieveProfilePByAdress(Adresse adresse);
	void affecterProfileAUser(int profileId, int userId);
	String StatProfession(Adresse adresse);
}

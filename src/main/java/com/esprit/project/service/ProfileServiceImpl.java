package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Adresse;
import com.esprit.project.entity.Preference;
import com.esprit.project.entity.Profession;
//import com.esprit.project.entity.Administrator;
import com.esprit.project.entity.Profile;
import com.esprit.project.entity.User;
//import com.esprit.project.repository.AdministratorRepository;
import com.esprit.project.repository.ProfileRepository;
import com.esprit.project.repository.UserRepository;




@Service
public class ProfileServiceImpl implements IProfileService{
	
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private static final Logger l = LogManager.getLogger(ProfileServiceImpl.class);
	
	@Override
	public List<Profile> retrieveAllProfiles(){
		List<Profile> profiles = (List<Profile>) profileRepository.findAll();
		for (Profile profile : profiles){
			l.info("Profile :" + profile);
		}
		return profiles;
	}
	@Override
	public Profile addProfile(Profile profile){
		return profileRepository.save(profile);
		
	}
	@Override
	public void deleteProfile(String id){
		long id1 = Long.parseLong(id);
		profileRepository.deleteById(id1);
	}
	@Override
	public Profile updateProfile(Profile profile){
		return profileRepository.save(profile);
	}
	@Override
	public Optional<Profile> retrieveProfile(String id){
		Optional<Profile> profile = profileRepository.findById(Long.parseLong(id));
		l.info("Profile :" + profile);
		return profile;
	}
	
	@Override
	public List<Profile> retrieveProfileKByAdress(Adresse adresse){
		 List<Profile> profiles = (List<Profile>) profileRepository.retrieveProfileKByAdress(adresse);
		 for (Profile profile : profiles){
				l.info("profile" + profile);
			}
		 return profiles;
	}
	
	@Override
	public List<Profile> retrieveProfilePByAdress(Adresse adresse){
		 List<Profile> profiles = (List<Profile>) profileRepository.retrieveProfilePByAdress(adresse);
		 for (Profile profile : profiles){
				l.info("profile" + profile);
			}
		 return profiles;
	}
	@Override
	public List<Profile> retrieveProfileByPreference(Preference preferncee) {
		List<Profile> profiles = (List<Profile>) profileRepository.retrieveProfileByPreference(preferncee);
		 for (Profile profile : profiles){
				l.info("profile" + profile);
			}
		 return profiles;
	}
	@Override
	public List<Profile> retrieveCibleProfileByAdress(Adresse adresse) {
		List<Profile> profiles = (List<Profile>) profileRepository.retrieveCibleProfileByAdress(adresse);
		 for (Profile profile : profiles){
				l.info("profile" + profile);
			}
		 return profiles;
	}
	
	@Override
	public String StatPrefernce(Adresse adresse) {
		List<Profile> profiles = (List<Profile>) profileRepository.retrieveProfilePByAdress(adresse);
		float ANIMATION = 0 ;
		float EXCURSION = 0;
		float PARTICIPATION = 0 ;
		Preference pref = null;
		float somme = 0;
		for (Profile profile : profiles){
		//String pref = profile.getPrefernce().toString();
			if (profile.getPrefernce() == pref.ANIMATION){
				ANIMATION++;
			}
			if (profile.getPrefernce() == pref.EXCURSION){
				EXCURSION = EXCURSION+1;
			}
			if (profile.getPrefernce() == pref.PARTICIPATION){
				PARTICIPATION = PARTICIPATION+1;
			}
		      }
	somme = ANIMATION+	EXCURSION+PARTICIPATION;
	return "ANIMATION présente" +Float.toString((float)(ANIMATION/somme)*100) +"EXCURSION présente" + Float.toString((float)(EXCURSION/somme)*100)+"PARTICIPATION présente" +Float.toString((float)(PARTICIPATION/somme)*100);
	
	}

	@Override
	public void affecterProfileAUser(int profileId, int userId) {
		Profile profile = profileRepository.findById((long) profileId).get();
		User user = userRepository.findById((long) userId).get();
		profile.setUser(user);
		user.setProfile(profile);
		profileRepository.save(profile);
		userRepository.save(user);
	}
	
	@Override
	public String StatProfession(Adresse adresse) {
		List<Profile> profiles = (List<Profile>) profileRepository.retrieveProfilePByAdress(adresse);
		float INGENIEUR = 0 ;
		float AVOCAT = 0;
		float MEDECIN = 0 ;
		float ENSEIGNANT = 0 ;
		Profession prof = null;
		float somme = 0;
		for (Profile profile : profiles){
		//String pref = profile.getPrefernce().toString();
			if (profile.getProfession() == prof.AVOCAT){
				AVOCAT++;
			}
			if (profile.getProfession() == prof.ENSEIGNANT){
				ENSEIGNANT++;
			}
			if (profile.getProfession() == prof.INGENIEUR){
				INGENIEUR++;
			}
			if (profile.getProfession() == prof.MEDECIN){
				MEDECIN++;
			}
			
		      }
	somme = AVOCAT+ENSEIGNANT+INGENIEUR+MEDECIN;
	return "AVOCAT présente  " +Float.toString((float)(AVOCAT/somme)*100)+" % " +" ENSEIGNANT présente " + Float.toString((float)(ENSEIGNANT/somme)*100)+" % "+" INGENIEUR présente " + Float.toString((float)(INGENIEUR/somme)*100) + " % "+" MEDECIN présente " + Float.toString((float)(MEDECIN/somme)*100) + " % ";
	
	}

}

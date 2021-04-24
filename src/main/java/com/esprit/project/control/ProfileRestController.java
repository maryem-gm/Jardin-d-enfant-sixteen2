package com.esprit.project.control;

/*import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;*/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Adresse;
import com.esprit.project.entity.Preference;
//import com.esprit.project.entity.Account;
//import com.esprit.project.entity.Administrator;
//import com.esprit.project.entity.Delegate;
//import com.esprit.project.entity.Inscription;
//import com.esprit.project.entity.KinderGarden;
//import com.esprit.project.entity.Parent;
import com.esprit.project.entity.Profile;
//import com.esprit.project.entity.User;
//import com.esprit.project.service.IAccountService;
//import com.esprit.project.service.IAdministratorService;
//import com.esprit.project.service.IDelegateService;
//import com.esprit.project.service.IInscriptionService;
//import com.esprit.project.service.IUserService;
//import com.esprit.project.service.IKinderGardenService;
//import com.esprit.project.service.IParentService;
import com.esprit.project.service.IProfileService;



@RestController
public class ProfileRestController {
	
	@Autowired 
	IProfileService profileService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-profiles
	@GetMapping("/retrieve-all-profiles")
	@ResponseBody
	public List<Profile> getProfile() {
	List<Profile> list = profileService.retrieveAllProfiles();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-profile/{profile-id}
	@GetMapping("/retrieve-profile/{profile-id}")
	@ResponseBody
	public Optional<Profile> retrieveProfile(@PathVariable("profile-id") String profileId) {
	return profileService.retrieveProfile(profileId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-profile
	@PostMapping("/add-profile")
	@ResponseBody
	public Profile addProfile(@RequestBody Profile profile1) {
	Profile profile = profileService.addProfile(profile1);
	return profile;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-profile/{profile-id}
	@DeleteMapping("/remove-profile/{profile-id}")
	@ResponseBody
	public void removeProfile(@PathVariable("profile-id") String profileId) {
		profileService.deleteProfile(profileId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-profile
	@PutMapping("/modify-profile")
	@ResponseBody
	public Profile modifyProfile(@RequestBody Profile profile) {
	return profileService.updateProfile(profile);
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-profileK-adress/{adress}
		@GetMapping("/retrieve-profileK-adress/{adress}")
		@ResponseBody
		public List<Profile> retrieveProfileKByAdress(@PathVariable("adress") String adresse) {
			Adresse adresse1 = Adresse.valueOf(adresse);
			return profileService.retrieveProfileKByAdress(adresse1);
			}
		// http://localhost:8081/SpringMVC/servlet/retrieve-profileP-adress/{adress}
				@GetMapping("/retrieve-profileP-adress/{adress}")
				@ResponseBody
				public List<Profile> retrieveProfilePByAdress(@PathVariable("adress") String adresse) {
					Adresse adresse1 = Adresse.valueOf(adresse);
					return profileService.retrieveProfilePByAdress(adresse1);
					}
		
	// http://localhost:8081/SpringMVC/servlet/retrieve-profile-preference/{preference}
		@GetMapping("/retrieve-profile-preference/{preference}")
		@ResponseBody
		public List<Profile> retrieveProfileByPreference(@PathVariable("preference") String preference) {
			Preference preference1 = Preference.valueOf(preference);
			return profileService.retrieveProfileByPreference(preference1);
					
	}
	// http://localhost:8081/SpringMVC/servlet/retrieve-cibleprofile-adress/{adress}
		@GetMapping("/retrieve-cibleprofile-adress/{adress}")
		@ResponseBody
		public List<Profile> retrieveCibleProfileByPreference(@PathVariable("adress") String adresse) {
			Adresse adresse1 = Adresse.valueOf(adresse);
			return profileService.retrieveCibleProfileByAdress(adresse1);
			}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-stat/{adress}
		@GetMapping("/retrieve-stat/{adress}")
		@ResponseBody
		public  String StatPrefernce(@PathVariable("adress") String adresse) {
					Adresse adresse1 = Adresse.valueOf(adresse);
					return profileService.StatPrefernce(adresse1);
			}
		
		// http://localhost:8081/SpringMVC/servlet/affect-profile-user/{idprofile}/{iduser}
				@PutMapping("/affect-profile-user/{idprofile}/{iduser}")
				//@ResponseBody
				public void affecterProfileAUser(@PathVariable("idprofile")int profileId,@PathVariable("iduser") int userId){
					profileService.affecterProfileAUser(profileId, userId);
				}
		// http://localhost:8081/SpringMVC/servlet/retrieve-stat-profession/{adress}
			@GetMapping("/retrieve-stat-profession/{adress}")
			@ResponseBody
			public  String StatProfession(@PathVariable("adress") String adresse) {
							Adresse adresse1 = Adresse.valueOf(adresse);
							return profileService.StatProfession(adresse1);
					}
		
}

package com.supi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supi.entity.CityEntity;
import com.supi.entity.CountryEntity;
import com.supi.entity.StateEntity;
import com.supi.entity.UserRegistrationForm;
import com.supi.repo.CityRepo;
import com.supi.repo.CountryRepo;
import com.supi.repo.StateRepo;
import com.supi.repo.UserRegistrationRepo;
import com.supi.util.RandomPwd;
import com.supi.util.SendEmail;

@Service
public class UserRegistrationServiceImlp implements UserRegistrationService{

	@Autowired
	private UserRegistrationRepo userRepo;
	
	@Autowired
	private CountryRepo countryRepo;
	
	@Autowired
	private StateRepo stateRepo;
	
	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private SendEmail sendMail;
	
	@Override
	public Map<Integer, String> getCountry() {
		// TODO Auto-generated method stub
		List<CountryEntity>  entity=countryRepo.findAll();
		
		Map<Integer, String> map = new HashMap<>(); 
		
		for(CountryEntity ce:entity) {
			
			map.put(ce.getCountryId(), ce.getCountryName());
		}
		return map;
	}

	@Override
	public Map<Integer, String> getState(Integer countryId) {
		// TODO Auto-generated method stub
		List<StateEntity> findByCountryId = stateRepo.findByCountryId(countryId);
		
         Map<Integer, String> map = new HashMap<>(); 
		
		for(StateEntity ce:findByCountryId) {
			
			map.put(ce.getStateId(), ce.getStateName());
		}
		return map;
		
	
	}

	@Override
	public Map<Integer, String> getCity(Integer stateId) {
		// TODO Auto-generated method stub
		
		List<CityEntity> findByStateId = cityRepo.findByStateId(stateId);
		

        Map<Integer, String> map = new HashMap<>(); 
		
		for(CityEntity ce: findByStateId ){
			
			map.put(ce.getCityId(), ce.getCityName());
		}
		return map;
		
		
	}

	@Override
	public String isEmailValid(String email) {
		// TODO Auto-generated method stub
		UserRegistrationForm findByEmail = (UserRegistrationForm) userRepo.findByEmail(email);
		if(findByEmail !=null) {
			return "Duplicate email";
		}
		
		return "unique email";
	}

	@Override
	public String saveUser(UserRegistrationForm userForm) {
		// TODO Auto-generated method stub
		
		userForm.setAccStatus("Locked");
		userForm.setUserPwd(RandomPwd.generateStrongPassword());
	//	userForm.setEmail(SendEmail.sendSimpleMessage(userForm));
		UserRegistrationForm userAccount=(UserRegistrationForm) userRepo.save(userForm);
		//String msg;
		
		if(userAccount != null) {
			
	//	return sendMail.sendSimpleMessage(userForm);
			//return sendMail.sendEmail(userForm);
			
			return sendMail.sendEmailForAccUnlock(userForm);
			
			
		}
		
		return "Registration Failed";
	}

}

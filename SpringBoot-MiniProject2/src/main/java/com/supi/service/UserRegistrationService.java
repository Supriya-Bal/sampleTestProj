package com.supi.service;

import java.util.Map;


import com.supi.entity.UserRegistrationForm;

public interface UserRegistrationService {
	
	
	public Map<Integer,String>  getCountry();
	public Map<Integer,String> getState(Integer countryId);
	public Map<Integer,String> getCity(Integer stateId);
	public String isEmailValid(String email);
	public String saveUser(UserRegistrationForm userForm);
	
	
	//public String  isTempPwdValid(String userEmail,String  )

    

}

package com.supi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supi.entity.UserRegistrationForm;
import com.supi.service.UserRegistrationService;



@RestController
@RequestMapping("/login")
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService userservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody UserRegistrationForm user) {
		
		 String saveUser = userservice.saveUser(user);
		 
		 return new ResponseEntity<>("User Save", HttpStatus.OK);
	 
}
}

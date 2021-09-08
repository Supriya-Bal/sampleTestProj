package com.supi.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.supi.entity.UserRegistrationForm;

public interface UserRegistrationRepo<T> extends JpaRepository<UserRegistrationForm, Serializable>{
	
	public List<UserRegistrationForm> findByEmail(String email);
	

}

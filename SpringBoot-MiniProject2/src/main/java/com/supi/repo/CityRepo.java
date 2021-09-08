package com.supi.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supi.entity.CityEntity;

public interface CityRepo extends JpaRepository<CityEntity, Serializable> {
	
	public List<CityEntity> findByStateId(Integer stateId);
	

}

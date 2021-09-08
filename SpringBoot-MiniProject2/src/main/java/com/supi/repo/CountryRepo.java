package com.supi.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supi.entity.CountryEntity;

public interface CountryRepo extends JpaRepository<CountryEntity, Serializable>{

}

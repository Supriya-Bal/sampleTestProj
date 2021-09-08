package com.supi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="USER_ACCOUNT")

public class UserRegistrationForm {
	
	@Id
	@Column(name="USER_ID")
	//@GeneratedValue(generator = "user_id_seq" ,strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private Long mobileNo;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="COUNTRY_ID")
	private String countryId;
	
	@Column(name="STATE_ID")
	private String stateId;
	
	@Column(name="CITY_ID")
	private String cityId;
	
	@Column(name="STATUS")
	private String AccStatus;
	
	@Column(name="PASSWORD")
	private String userPwd;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="UPDATE_DATE")
	private Date updateDate;
	

}

package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "USER_DETAILS ")
public class UserRegistrationDetailsEntity {
	@Column(name="User_Id")
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer userId;
	@Column(name = "User_Name")
	private String uName;
	@Column(name = "User_Email")
	private String uEmail;
	@Column(name = "User_PhoneNo")
	private Long phNo;
	@Column(name = "User_Status")
	private String status;
	@Column(name="User_Pwd")
	private String uPwd;
	 
	
}

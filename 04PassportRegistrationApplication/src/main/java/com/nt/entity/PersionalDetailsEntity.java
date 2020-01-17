package com.nt.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name = "PERSIONAL_DTL")
public class PersionalDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "P_ID",length = 5)
	private int pid;
	
	@Column(name = "FIRST_NAME",length = 10)
	private String fname;
	@Column(name = "LAST_NAME",length = 10)
	
	private String lname;
	@Column(name = "EMAIL",length = 30)
	
	private String email;
	@Column(name = "GENDER",length = 5)
	private String gender;
	
	@Column(name = "DOB")
	private Date dob; 
	
	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	private Date createDate;
	
	@Column(name = "UPDATE_DATE")
	@UpdateTimestamp
	private Date updateDate;
}

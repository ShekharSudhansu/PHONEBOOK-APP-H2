package com.nt.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class PersionalDetailsBean {
	private int pid;
	private String fname;
	private String lname;
	private String email;
	private String gender;
	private Date dob;
}

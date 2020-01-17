package com.hix.domain;

import java.sql.Date;

import lombok.Data;
@Data
public class CitizenDetailsDomain {
	private String fname;
	private String lname;
	private String gender;
	private Date dob;
	private String stateName;
	private String ssNo;
}

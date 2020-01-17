package com.hix.service;

import java.util.List;

import com.hix.domain.CitizenDetailsDomain;


public interface SsaMngtService {
	public List<String> getAllStates();
	public CitizenDetailsDomain saveCitizenDetails(CitizenDetailsDomain domain);
	public String getStateCodeByStateName(String stateName);
	public String getStateCodeBySSN(String ssNo);
}

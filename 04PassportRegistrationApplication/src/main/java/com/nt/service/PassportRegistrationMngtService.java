package com.nt.service;

import java.util.List;

import com.nt.domain.EducationaldetailsBean;
import com.nt.domain.HigherDegreeBean;
import com.nt.domain.PassoutYearBean;
import com.nt.domain.PassportAppDetaisBean;
import com.nt.domain.PersionalDetailsBean;
import com.nt.domain.UniversityBean;

public interface PassportRegistrationMngtService {
	public PersionalDetailsBean savePersionalDetails(PersionalDetailsBean pBean);
	public List<HigherDegreeBean> fetchAllDegree();
	public List<UniversityBean> fetchAllUnv();
	public List<PassoutYearBean> fetchPassoutYr();
	public PersionalDetailsBean fecthDetailsById(Integer pid);
	public EducationaldetailsBean fecthEDdetailsById(Integer eid);
	public EducationaldetailsBean saveEDdetails(EducationaldetailsBean edBean);
	public PassportAppDetaisBean savePassPortDetails(PassportAppDetaisBean pAppBean);
}

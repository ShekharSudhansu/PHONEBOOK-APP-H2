package com.nt.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.nt.domain.EducationaldetailsBean;
import com.nt.domain.HigherDegreeBean;
import com.nt.domain.PassoutYearBean;
import com.nt.domain.PassportAppDetaisBean;
import com.nt.domain.PersionalDetailsBean;
import com.nt.domain.UniversityBean;
import com.nt.entity.EducationalDetailsEntity;
import com.nt.entity.HigherDegreeEntity;
import com.nt.entity.PassoutYrMstEntity;
import com.nt.entity.PassportAppDetaisEntity;
import com.nt.entity.PersionalDetailsEntity;
import com.nt.entity.UniversityEntity;
import com.nt.repositry.EducationalDetailsRepositry;
import com.nt.repositry.HigherDegreeRepositry;
import com.nt.repositry.PassPortDetailsRepositry;
import com.nt.repositry.PassoutYearRepositry;
import com.nt.repositry.PersionalDetailsRepositry;
import com.nt.repositry.UniversityRepositry;

/**
 * This class for manage all bussines operation
 * 
 * @author shekhar
 *
 */
@Service
public class PassportRegistrationMngtServiceImpl implements PassportRegistrationMngtService {
	@Autowired
	private PersionalDetailsRepositry persionalDtlRepo;
	@Autowired
	private HigherDegreeRepositry degreeRepo;
	@Autowired
	private UniversityRepositry unvRepo;
	@Autowired
	private PassoutYearRepositry yrRepo;
	@Autowired
	private EducationalDetailsRepositry edRepo;
	@Autowired
	private PassPortDetailsRepositry pAppRepo;

	/**
	 * This method used for save persional details data
	 */
	@Override
	public PersionalDetailsBean savePersionalDetails(PersionalDetailsBean pBean) {
		PersionalDetailsEntity entity = new PersionalDetailsEntity();
		BeanUtils.copyProperties(pBean, entity);
		PersionalDetailsEntity save = persionalDtlRepo.save(entity);
		BeanUtils.copyProperties(entity, pBean);
		return pBean;
	}

	/**
	 * This method for fetching all records of Degree_master table
	 */

	@Override
	public List<HigherDegreeBean> fetchAllDegree() {
		List<HigherDegreeEntity> listEntity = degreeRepo.findAll();
		List<HigherDegreeBean> listBean = new ArrayList<HigherDegreeBean>();
		listEntity.forEach(entity -> {
			HigherDegreeBean dbean = new HigherDegreeBean();
			BeanUtils.copyProperties(entity, dbean);
			listBean.add(dbean);
		}

		);
		return listBean;
	}

	@Override
	public List<UniversityBean> fetchAllUnv() {
		List<UniversityEntity> listUnvEntity = unvRepo.findAll();
		List<UniversityBean> listUnvBean = new ArrayList();
		listUnvEntity.forEach(entity -> {
			UniversityBean unvBean = new UniversityBean();
			BeanUtils.copyProperties(entity, unvBean);
			listUnvBean.add(unvBean);
		});
		return listUnvBean;
	}

	@Override
	public List<PassoutYearBean> fetchPassoutYr() {
		List<PassoutYrMstEntity> listTrEntity = yrRepo.findAll();
		List<PassoutYearBean> listYrBean = new ArrayList();
		listTrEntity.forEach(entity -> {
			PassoutYearBean yrBean = new PassoutYearBean();
			BeanUtils.copyProperties(entity, yrBean);
			listYrBean.add(yrBean);
		});
		return listYrBean;
	}

	@Override
	public PersionalDetailsBean fecthDetailsById(Integer pid) {
		PersionalDetailsBean pdBean = new PersionalDetailsBean();
		PersionalDetailsEntity detailsByIdEntity = persionalDtlRepo.getDetailsById(pid);
		BeanUtils.copyProperties(detailsByIdEntity, pdBean);
		System.out.println(pdBean);
		return pdBean;
	}

	public EducationaldetailsBean saveEDdetails(EducationaldetailsBean edBean) {
		EducationaldetailsBean bean = new EducationaldetailsBean();
		PersionalDetailsEntity pd = new PersionalDetailsEntity();
		EducationalDetailsEntity entity = new EducationalDetailsEntity();
		BeanUtils.copyProperties(edBean, entity);
		pd.setPid(edBean.getPid());
		entity.setEntity(pd);
		EducationalDetailsEntity saveEntity = edRepo.save(entity);
		BeanUtils.copyProperties(saveEntity, bean);
		bean.setPid(saveEntity.getEntity().getPid());
		return bean;
	}

	@Override
	public EducationaldetailsBean fecthEDdetailsById(Integer eid) {
		EducationaldetailsBean edBean = new EducationaldetailsBean();
		EducationalDetailsEntity eDdetailsEntity = edRepo.getEDdetailsById(eid);
		BeanUtils.copyProperties(eDdetailsEntity, edBean);
		return edBean;
	}

	public PassportAppDetaisBean savePassPortDetails(PassportAppDetaisBean pAppBean) {
		pAppBean.setPassPortNo(getAlphaNumericString(8));
		PersionalDetailsEntity pd = new PersionalDetailsEntity();
		PassportAppDetaisEntity entity = new PassportAppDetaisEntity();
		BeanUtils.copyProperties(pAppBean, entity);
		pd.setPid(pAppBean.getPid());
		entity.setEntity(pd);
		PassportAppDetaisEntity saveEntity = pAppRepo.save(entity);
		BeanUtils.copyProperties(entity, pAppBean);
		pAppBean.setPid(entity.getEntity().getPid());
		return pAppBean;
	}

	private String getAlphaNumericString(int number) {
		int no = number;
		// length is bounded by 256 Character
		byte[] array = new byte[256];
		new Random().nextBytes(array);

		String randomString = new String(array, Charset.forName("UTF-8"));

		// Create a StringBuffer to store the result
		StringBuilder r = new StringBuilder();

		// remove all spacial char
		String AlphaNumericStr = randomString.replaceAll("[^A-Za-z0-9]", "");

		// Append first 20 alphanumeric characters
		// from the generated random String into the result
		for (int k = 0; k < AlphaNumericStr.length(); k++) {

			if (Character.isLetter(AlphaNumericStr.charAt(k)) && (no > 0)
					|| Character.isDigit(AlphaNumericStr.charAt(k)) && (no > 0)) {

				r.append(AlphaNumericStr.charAt(k));
				no--;
			}
		}

		// return the resultant string
		return r.toString();
	}

}

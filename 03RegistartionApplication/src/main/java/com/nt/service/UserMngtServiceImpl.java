package com.nt.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.domain.UserDetails;
import com.nt.domain.UserLoginDetails;
import com.nt.domain.UserUnlockDetailsBean;
import com.nt.entity.UserRegistrationDetailsEntity;
import com.nt.repositry.UserRegistartionDetailsRepositry;
import com.nt.utility.MailUtility;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserMngtServiceImpl implements UserMngtService {
	@Autowired
	private UserRegistartionDetailsRepositry userRepo;
	@Autowired
	private MailUtility mailUtil;

	/**
	 * This method for saveing user details.
	 */
	@Override
	public boolean saveUserDetails(UserDetails bean){
		UserRegistrationDetailsEntity entity = new UserRegistrationDetailsEntity();
		bean.setStatus("Unlock");
		bean.setUPwd(getAlphaNumericString(4));
		BeanUtils.copyProperties(bean, entity);
		UserRegistrationDetailsEntity result = userRepo.save(entity);
		if (result.getUserId() > 0) {
			try {
				sendEmail(bean);
			} catch (Exception e) {
				 log.error("Mail not sended");
			}
		}
		return result.getUserId() > 0;
	}

	/**
	 * this method for generating random alphanumeric value
	 * 
	 * @param n
	 * @return
	 */
	private String getAlphaNumericString(int number) {
		int no=number;
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

	public void sendEmail(UserDetails details)   {
		String fileName = "userTemplate";
		StringBuilder sb = new StringBuilder();
		FileReader reader=null;
		try {
			reader = new FileReader(new File(fileName));
		} catch (FileNotFoundException e) {
			 log.error("File not found");
		}
		BufferedReader br = new BufferedReader(reader);
		String line=null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			 log.error("FileReader not found");
		}
		while (line != null) {
			if (line.contains("${NAME}")) {
				line = line.replace("${NAME}", details.getUName());
				sb.append(line);
			}
			if (line.contains("${PWD}")) {
				line = line.replace("${PWD}", details.getUPwd());
				sb.append(line);
			}
			if (line.contains("${EMAILID}")) {
				line = line.replace("${EMAILID}", details.getUEmail());
				sb.append(line);
			}
			try {
				line = br.readLine();
			} catch (IOException e) {
				log.error("Buffer not able to reading the file");
			}
		}
		try {
			reader.close();
		} catch (IOException e) {
			 log.error("fileReader not close");
		}
		try {
			mailUtil.sendMail(details.getUEmail(), sb.toString(), "Greetings for the day");
		} catch (MessagingException e) {
			 log.error("message not sended");;
		}
	}// method

	@Override
	public boolean checkValidEmailId(UserUnlockDetailsBean bDetailsBean) {
		UserRegistrationDetailsEntity entity = new UserRegistrationDetailsEntity();
		System.out.println(bDetailsBean.getPwd());
		entity.setUEmail(bDetailsBean.getEmail());
		entity.setUPwd(bDetailsBean.getPwd());

		System.out.println(entity.getUEmail());
		entity = userRepo.getRecordByEmailAndPwd(entity.getUEmail(), entity.getUPwd());
		UserRegistrationDetailsEntity save=null;
		 
		if (entity!=null && entity.getUserId() > 0) {
			entity.setStatus("unlock");
			entity.setUPwd(bDetailsBean.getConfirmPwd());
			save = userRepo.save(entity);
		}
		return (save!=null)?save.getUserId() > 0:false;
	}

	@Override
	public UserRegistrationDetailsEntity checkCredintials(UserLoginDetails details) {
		UserRegistrationDetailsEntity entity = new UserRegistrationDetailsEntity();
		entity.setUEmail(details.getEmail());
		entity.setUPwd(details.getPwd());
		
		return userRepo.getRecordByEmailAndPwd(entity.getUEmail(),
				entity.getUPwd());
	}

	/**
	 * This method for fetching record from DB by email id
	 * @throws Exception 
	 */
	@Override
	public boolean fetchRecordByEmailId(String email)   {
		String pwd = userRepo.getRecordByEmailId(email);
		if (pwd != null) {
			 
				try {
					sendEmailToUser(email, pwd);
				} catch (Exception e) {
					 log.error("Mail not sended to user");
				}

			 
		}
		return pwd != null;
	}

	
	/**
	 * This method for reading text form file for email
	 * @param email
	 * @param pwd
	 * @throws Exception
	 */
	
	public void sendEmailToUser(String email, String pwd) throws Exception {
		System.out.println("UserMngtServiceImpl.sendEmailToUser()");

		String fileName = "forgetEmailTemplate";
		StringBuilder sb = new StringBuilder();
		FileReader reader = new FileReader(new File(fileName));
		BufferedReader br = new BufferedReader(reader);
		String line = br.readLine();
		while (line != null) {
			if (line.contains("${EMAIL}")) {
				line = line.replace("${EMAIL}", email);
				sb.append(line);
			}
			if (line.contains("${PWD}")) {
				line = line.replace("${PWD}", pwd);
				sb.append(line);
			}
			line = br.readLine();
		}
		reader.close();
		mailUtil.sendEmailForPwd(email, sb.toString(), "Your Password");
	}
	
	/**
	 * This method for fetch all records from DB
	 */
	@Override
	public List<UserDetails> fetchAllUserRecords() {
		List<UserRegistrationDetailsEntity> listEntity;
		List<UserDetails> listDetails=new ArrayList();
		listEntity=userRepo.findAll();
		listEntity.forEach(entity->{
			UserDetails details=new UserDetails();
			BeanUtils.copyProperties(entity, details);
			listDetails.add(details);
		});
		return listDetails;
	}
	
	/**
	 * This method for get record from DB by email id
	 */
	
	@Override
	public String getRecoredByEmailId(String email){
		UserRegistrationDetailsEntity findByuEmail = userRepo.findByuEmail(email);
		if(findByuEmail!=null) {
			return "Duplicate";
		}
		return "Unique";
	}
	
}

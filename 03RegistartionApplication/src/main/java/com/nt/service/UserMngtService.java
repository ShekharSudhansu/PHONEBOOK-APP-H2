package com.nt.service;

import java.util.List;

import com.nt.domain.UserDetails;
import com.nt.domain.UserLoginDetails;
import com.nt.domain.UserUnlockDetailsBean;
import com.nt.entity.UserRegistrationDetailsEntity;

public interface UserMngtService {
			public boolean saveUserDetails(UserDetails bean) throws Exception;
			public boolean checkValidEmailId(UserUnlockDetailsBean detailsBean);
			public UserRegistrationDetailsEntity checkCredintials(UserLoginDetails details);
			public boolean fetchRecordByEmailId(String email);
			public List<UserDetails> fetchAllUserRecords();
			public String getRecoredByEmailId(String email);
}

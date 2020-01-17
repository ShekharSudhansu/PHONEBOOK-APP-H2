package com.nt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.UserRegistrationDetailsEntity;


public interface UserRegistartionDetailsRepositry extends JpaRepository<UserRegistrationDetailsEntity, Integer> {
	@Query(value="FROM UserRegistrationDetailsEntity WHERE uEmail=:email AND uPwd=:pwd")
	public UserRegistrationDetailsEntity getRecordByEmailAndPwd(String email,String pwd);
	@Query(value="SELECT uPwd FROM UserRegistrationDetailsEntity WHERE uEmail=:email")
	public String getRecordByEmailId(String email);
	@Query(value="from UserRegistrationDetailsEntity where uEmail=:email ")
	public UserRegistrationDetailsEntity findByuEmail(String email);
}

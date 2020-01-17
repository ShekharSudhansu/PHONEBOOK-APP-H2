package com.nt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.UserRegistrationDetailsEntity;


public interface UserRegistartionDetailsRepositry extends JpaRepository<UserRegistrationDetailsEntity, Integer> {

}

package com.hix.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hix.entity.StateMasterEntity;

public interface StateRepositry extends JpaRepository<StateMasterEntity, Integer> {
	@Query("SELECT stateCode FROM StateMasterEntity WHERE stateName=:stateName")		
	public String getCodeByStateName(String stateName);
}

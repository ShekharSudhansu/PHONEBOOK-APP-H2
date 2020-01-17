package com.hix.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hix.entity.CitizenDetailsEntity;

public interface CitizenRepositry extends JpaRepository<CitizenDetailsEntity,String>{
	@Query("select stateCode from CitizenDetailsEntity where ssNo=:ssNo")
	public String getStateCode(String ssNo);
}

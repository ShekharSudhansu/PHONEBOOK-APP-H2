package com.nt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.EducationalDetailsEntity;

public interface EducationalDetailsRepositry extends JpaRepository<EducationalDetailsEntity, Integer> {
	@Query("FROM EducationalDetailsEntity WHERE eid=:eid")
	public EducationalDetailsEntity getEDdetailsById(Integer eid);
}

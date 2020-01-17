package com.nt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.PersionalDetailsEntity;

public  interface PersionalDetailsRepositry extends JpaRepository<PersionalDetailsEntity,Integer> {
	@Query("FROM PersionalDetailsEntity WHERE pid=:pid")	
	public PersionalDetailsEntity getDetailsById(Integer pid);
}

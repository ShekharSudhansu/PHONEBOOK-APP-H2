package com.nt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CityMasterEntity;

public interface CityMasterRepositry extends JpaRepository<CityMasterEntity,Integer> {

}

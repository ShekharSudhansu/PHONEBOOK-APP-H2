package com.nt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CountryMasterEntity;


public interface CountryMasterRepositry extends JpaRepository<CountryMasterEntity,Integer> {

}

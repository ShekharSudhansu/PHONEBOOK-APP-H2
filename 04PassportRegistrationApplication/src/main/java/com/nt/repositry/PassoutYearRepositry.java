package com.nt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.PassoutYrMstEntity;

public  interface PassoutYearRepositry extends JpaRepository<PassoutYrMstEntity,Integer> {

}

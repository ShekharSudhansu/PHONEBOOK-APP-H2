package com.nt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.PassoutYrMstEntity;
import com.nt.entity.UniversityEntity;

public  interface UniversityRepositry extends JpaRepository< UniversityEntity,Integer> {

}

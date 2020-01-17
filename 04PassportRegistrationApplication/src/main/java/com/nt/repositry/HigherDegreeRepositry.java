package com.nt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.HigherDegreeEntity;
import com.nt.entity.PersionalDetailsEntity;

public  interface HigherDegreeRepositry extends JpaRepository<HigherDegreeEntity ,Integer> {

}

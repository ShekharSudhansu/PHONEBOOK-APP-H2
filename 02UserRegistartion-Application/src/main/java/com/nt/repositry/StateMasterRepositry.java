package com.nt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.StateMasterEntity;

public interface StateMasterRepositry extends JpaRepository<StateMasterEntity,Integer> {

}

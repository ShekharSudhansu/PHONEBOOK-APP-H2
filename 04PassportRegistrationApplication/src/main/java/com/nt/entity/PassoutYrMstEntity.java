package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="years_master")
public class PassoutYrMstEntity {
	@Id
	@Column(name = "YEAR_ID")
	private Integer yrId;
	private Integer year;
}

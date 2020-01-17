package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="unv_master")
public class UniversityEntity {
	@Id
	@Column(name = "UNV_ID")
	private Integer unvId;
	private String  unvName;
}

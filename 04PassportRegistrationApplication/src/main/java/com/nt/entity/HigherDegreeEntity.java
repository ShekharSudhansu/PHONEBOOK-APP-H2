package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table( name="degree_master")
public class HigherDegreeEntity {
	@Id
	@Column(name = "DEGREE_ID")
	private Integer digreeId;
	private String  degreeName;
}

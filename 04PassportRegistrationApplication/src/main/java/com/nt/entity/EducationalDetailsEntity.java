package com.nt.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name="EDUCATION_DTL")
public class EducationalDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "E_ID",length = 5)
	private Integer eid;

	@OneToOne
	@JoinColumn(name = "P_ID")
	 private PersionalDetailsEntity entity;
	
	@Column(name = "DEGREE",length = 10)
	private String degree;
	
	@Column(name = "UNV_NAME",length = 10)
	private String unvName;
	
	@Column(name = "PASSOUT_YEAR",length = 5)
	private Integer passOutYr;
	
	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	private Date createDate;
	
	@Column(name = "UPDATE_DATE")
	@UpdateTimestamp
	private Date updateDate;
}

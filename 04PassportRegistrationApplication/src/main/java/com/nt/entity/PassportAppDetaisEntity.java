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
@Table(name="Passport_App_Dtl")
public class PassportAppDetaisEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer passPortId;
		@OneToOne
		@JoinColumn(name = "P_ID")
		private PersionalDetailsEntity entity;
		@Column(name = "Passport_No")
		private String passPortNo;
		
		@Column(name = "CREATE_DATE")
		@CreationTimestamp
		private Date createDate;
		
		
		@UpdateTimestamp
		@Column(name = "UPDATE_DATE")
		private Date updateDate;

}

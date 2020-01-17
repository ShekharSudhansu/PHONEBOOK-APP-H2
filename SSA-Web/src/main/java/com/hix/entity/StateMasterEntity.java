package com.hix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="STATE_MASTER")
@Data
public class StateMasterEntity {
		@Id
		@Column(name="STATEID",length = 3)
		private Integer sId;
		@Column(name="STATENAME",length = 20)
		private String stateName;
		@Column(name="STATECODE",length = 20)
		private String stateCode; 
}

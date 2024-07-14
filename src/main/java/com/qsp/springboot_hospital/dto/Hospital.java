package com.qsp.springboot_hospital.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospitalId;
	
	private String hospitalName;
	
	@Column(unique = true)
	private String hospitalEmail;
	
	private String ceo;
	
	

}

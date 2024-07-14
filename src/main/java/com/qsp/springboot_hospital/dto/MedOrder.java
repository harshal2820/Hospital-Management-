package com.qsp.springboot_hospital.dto;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MedOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medOrderId;
	
	private Date date;
	
	private String doctor;
	
	@ManyToOne
	private Encounter encounter;

}

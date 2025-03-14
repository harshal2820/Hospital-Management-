package com.qsp.springboot_hospital.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
public class Encounter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int encounterId;
	
	private String cause;
	
	private double cost;
	@ManyToOne
	private Person person;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Branch> branches; 
}

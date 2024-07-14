package com.qsp.springboot_hospital.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	
	
	@NotBlank(message = "Name Can't be Blank")
	@NotNull(message="name can't be null")
	private String personName;
	
	
	@NotNull(message = "phone can't be null")
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	@Column(unique = true)
	private long phone;
	
	
	@NotBlank(message="email can't be blank")
	@NotNull(message="Email can't be null")
	@Email(regexp = "[a-z0-9._+$]+@[a-z0-9]+\\.[a-z]{2,3}",message="Invalid Email")
	@Column(unique = true)
	private String personEmail;
	
	
	
	
	@NotBlank(message = "Address Can't be Blank")
	@NotNull(message="Address can't be null")
	private String personAddress;
	
	
	
	

}

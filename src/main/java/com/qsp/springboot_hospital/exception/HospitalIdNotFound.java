package com.qsp.springboot_hospital.exception;

public class HospitalIdNotFound  extends RuntimeException{
	
	String message="Hospital With given Id Not Found";
	
	
//	@Override
//	public String getMessage() {
//		// TODO Auto-generated method stub
//		return message;
//	}

	
	public HospitalIdNotFound(String message) {
		super(message);
	}
}

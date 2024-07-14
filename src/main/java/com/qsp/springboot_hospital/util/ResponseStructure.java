package com.qsp.springboot_hospital.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private String message;
	
	private int statusCode;
	
	private T data;
	
	
	/*
	 * 201 created  save
	 * 302 found success
	 * 404 not found  not updated
	 * 200 OK   delete
	 */

}

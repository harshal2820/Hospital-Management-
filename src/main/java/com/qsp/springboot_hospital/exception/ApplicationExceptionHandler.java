package com.qsp.springboot_hospital.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.springboot_hospital.util.ResponseStructure;


@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(HospitalIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> hospitalIdNotFoundExceptionHandler(HospitalIdNotFound found){
		
		ResponseStructure<String> structure=new  ResponseStructure<String>();
		
		structure.setMessage("Hospital Id Not Found Exception");
		
		structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		
		structure.setData(found.getMessage());
		
		return  new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		List<ObjectError> errors=ex.getAllErrors();
		Map<String,String> map=new HashMap<String, String>();
		
		for(ObjectError error:errors) {
			FieldError fieldError=(FieldError) error;
			
			String name=fieldError.getField();
			
			String mesage=fieldError.getDefaultMessage();
			
			map.put(name, mesage);
		}
		
		return new  ResponseEntity<Object>(map,status);
		
	}
	
	

}

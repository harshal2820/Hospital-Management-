package com.qsp.springboot_hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospital.dto.Hospital;
import com.qsp.springboot_hospital.service.HospitalService;
import com.qsp.springboot_hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	
	@ApiOperation(notes = "this Api must be used to saved hospital details in the database", value = "Save Hopsital Api")
	@ApiResponses(value= {@ApiResponse(code=201,message="Data saved Successfully")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		
		return service.saveHospital(hospital);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id) {
		return service.getHospitalById(id);
	}
	
	@DeleteMapping
	public ResponseStructure<Hospital> deleteHospitalById(@RequestParam int id) {
		return service.deleteHospitalById(id);
	}
	@PutMapping
	public ResponseStructure<Hospital> updateHospitalById(@RequestParam  int id,@RequestBody Hospital hospital) {
		return service.updateHospitalById(id,hospital);
	}
	
	@GetMapping("/findhospitalbyemail")
	public ResponseStructure<Hospital> getHospitalByEmail(@RequestParam String email) {
	 return	service.getHospitalByEmail(email);
	}
 }

package com.qsp.springboot_hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospital.dto.Address;
import com.qsp.springboot_hospital.service.AddressService;
import com.qsp.springboot_hospital.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService service;
	
	@PostMapping
	public ResponseStructure<Address> saveAddress(@RequestBody Address address) {
		
		return service.saveAddress(address);
	}
	@GetMapping
	public ResponseStructure<Address> getAddressById(@RequestParam int id) {
		return service.getAddressById(id);
	}
	
	@DeleteMapping
	public ResponseStructure<Address> deleteAddressById(@RequestParam int id) {
		return service.deleteAddressById(id);
	}
	@PutMapping
	public ResponseStructure<Address> updateAddressById(@RequestParam  int id,@RequestBody Address address) {
		return service.updateAddressById(id,address);
	}
	
	@GetMapping("/pincode")
	public ResponseStructure<Address> getAddressByPincode( @RequestParam int pincode) {
		return service.getAddressByPincode(pincode);
	}
	
	

	
	
	
}

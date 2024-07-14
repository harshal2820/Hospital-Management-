package com.qsp.springboot_hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospital.dto.Branch;
import com.qsp.springboot_hospital.service.BranchService;
import com.qsp.springboot_hospital.util.ResponseStructure;
@RestController
@RequestMapping("/branch")
public class BranchController {
	@Autowired
	private BranchService service;
	@PostMapping
	public ResponseStructure<Branch> saveBranch(@RequestParam int hospitalId,@RequestParam int addressId,@RequestBody Branch branch) {
		
		return service.saveBranch(hospitalId,addressId,branch);
	}
	@GetMapping("/getbranchbyhospital")
	public ResponseStructure<List<Branch>> getBranchByHospital(@RequestParam int hospitalId){
		return service.getBranchByHospital(hospitalId);
	}
	
	@GetMapping
	public ResponseStructure<Branch> getBranchById(@RequestParam int branchId) {
		return service.getBranchById(branchId);
	}
	
	@DeleteMapping
	public ResponseStructure<Branch> deleteBranchById(@RequestParam int branchId) {
		return service.deleteBranchById(branchId);
	}
	
	@PutMapping
	public ResponseStructure<Branch> updateBranch(@RequestParam int branchId,@RequestBody Branch branch) {
		return service.updateBranch(branchId, branch);
	}
	@GetMapping("/getbranchbyaddress")
	public ResponseStructure<Branch> getBranchByAddressId(@RequestParam int addressId) {
		return service.getBranchByAddressId(addressId);
	}

}

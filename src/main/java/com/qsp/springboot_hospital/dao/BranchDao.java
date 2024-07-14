package com.qsp.springboot_hospital.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.dto.Address;
import com.qsp.springboot_hospital.dto.Branch;
import com.qsp.springboot_hospital.dto.Hospital;
import com.qsp.springboot_hospital.repo.BranchRepo;
@Repository
public class BranchDao {
	@Autowired
	private BranchRepo repo;

	public Branch saveBranch(Branch branch) {
		
		// TODO Auto-generated method stub
		return repo.save(branch);
	}
	
	public List<Branch> getBranchByHospital(Hospital hospital){
		
		return repo.findBranchByHospital(hospital);
	}

	public Branch getBranch(int branchid) {
		// TODO Auto-generated method stub
		Optional<Branch> optional=repo.findById(branchid);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
		
	}
	
	public void deleteBranch(Branch branch) {
		repo.delete(branch);
		
	}
	
	public Branch getbranchByAddress(Address address) {
		
		return repo.findBranchByAddress(address);
		
	}

}

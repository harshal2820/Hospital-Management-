package com.qsp.springboot_hospital.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospital.dto.Address;
import com.qsp.springboot_hospital.dto.Branch;
import com.qsp.springboot_hospital.dto.Hospital;

public interface BranchRepo  extends JpaRepository<Branch,Integer> {
	
	List<Branch> findBranchByHospital(Hospital hospital);
	
	Branch findBranchByAddress(Address address);

}

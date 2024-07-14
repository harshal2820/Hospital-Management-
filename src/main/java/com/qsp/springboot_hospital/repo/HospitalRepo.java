package com.qsp.springboot_hospital.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospital.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital,Integer> {
	
	Hospital findHospitalByHospitalEmail(String email);

}

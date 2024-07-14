package com.qsp.springboot_hospital.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.dto.Hospital;
import com.qsp.springboot_hospital.repo.HospitalRepo;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepo repo;
	
	
	public Hospital saveHospital(Hospital hospital) {
		
		return repo.save(hospital);
	}
	
	public Hospital getHospitalById(int id) {
		 Optional<Hospital> optional= repo.findById(id);
		 
		 if(optional.isPresent()) {
			 return optional.get();
		 }
		 
		 return null;
	}

	public Hospital deleteHospitalById(int id) {
		Optional<Hospital> optional=repo.findById(id);
		
		if(optional.isEmpty()) {
		return null;
		}
		repo.delete(optional.get());
		return optional.get();
	}

	public Hospital updateHospitalById(int id,Hospital hospital) {
		// TODO Auto-generated method stub
		Optional<Hospital> optional=repo.findById(id);
		if(optional.isPresent()) {
		 hospital.setHospitalId(id);
		 
		 return repo.save(hospital);
		}
		return null;
	}

	public Hospital getHospitalByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findHospitalByHospitalEmail(email);
	}
	


}

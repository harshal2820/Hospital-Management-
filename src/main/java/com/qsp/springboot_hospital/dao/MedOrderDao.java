package com.qsp.springboot_hospital.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.dto.Encounter;
import com.qsp.springboot_hospital.dto.MedOrder;
import com.qsp.springboot_hospital.repo.MedOrderRepo;

@Repository
public class MedOrderDao {

	@Autowired
	private MedOrderRepo repo;
	
	public MedOrder saveMedOrder(MedOrder medOrder) {
		// TODO Auto-generated method stub
		return repo.save(medOrder);
	}

	public MedOrder getMedOrderById(int id) {
		// TODO Auto-generated method stub
		Optional<MedOrder> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	

	

	public void deleteMedOrder(MedOrder medOrder) {
		// TODO Auto-generated method stub
		repo.delete(medOrder);
	}
	
	public List<MedOrder> getMedOrderByEncounter(Encounter encounter) {
		
		return repo.findMedOrderByEncounter(encounter);
		
	}
	
	public List<MedOrder> getMedOrderByDoctor(String doctor){
		
		return repo.findMedOrderByDoctor(doctor);
		
	}
}

package com.qsp.springboot_hospital.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.dto.Encounter;
import com.qsp.springboot_hospital.dto.MedItems;
import com.qsp.springboot_hospital.dto.MedOrder;
import com.qsp.springboot_hospital.repo.MedItemsRepo;

@Repository
public class MedItemsDao {
	
	@Autowired
	private MedItemsRepo repo;
	
	public MedItems saveMedItems(MedItems medItems) {
		// TODO Auto-generated method stub
		return repo.save(medItems);
	}

	public MedItems getMedItemsById(int id) {
		// TODO Auto-generated method stub
		Optional<MedItems> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	

	

	public void deleteMedItems(MedItems medItems) {
		// TODO Auto-generated method stub
		repo.delete(medItems);
	}
	
	public List<MedItems> getMedItemsByMedOrder(MedOrder medOrder) {
		
		return repo.findMedItemsByMedOrder(medOrder);
		
	}
	
	
	

}

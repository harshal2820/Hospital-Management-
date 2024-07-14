package com.qsp.springboot_hospital.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospital.dto.Encounter;
import com.qsp.springboot_hospital.dto.MedOrder;

public interface MedOrderRepo  extends JpaRepository<MedOrder,Integer>{

	List<MedOrder> findMedOrderByEncounter(Encounter encounter);

	List<MedOrder> findMedOrderByDoctor(String doctor);
	

	
	

}

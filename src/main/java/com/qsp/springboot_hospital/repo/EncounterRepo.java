package com.qsp.springboot_hospital.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospital.dto.Branch;
import com.qsp.springboot_hospital.dto.Encounter;
import com.qsp.springboot_hospital.dto.Person;

public interface EncounterRepo extends JpaRepository<Encounter, Integer> {
	
	
	List<Encounter>  findEncounterByPerson(Person person);
	
//	List<Branch> findBranchByEncounter(Encounter encounter);

}

package com.qsp.springboot_hospital.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.dto.Branch;
import com.qsp.springboot_hospital.dto.Encounter;
import com.qsp.springboot_hospital.dto.Person;
import com.qsp.springboot_hospital.repo.EncounterRepo;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepo repo;

	public Encounter saveEncounter(Encounter encounter) {

		return repo.save(encounter);
	}

	public Encounter getEncounter(int encounterId) {
		Optional<Encounter> optional = repo.findById(encounterId);
		if (optional.isEmpty()) {
			return null;
		}

		return optional.get();

	}

	public void deleteEncounter(Encounter encounter) {
		repo.delete(encounter);

	}

	public List<Encounter> getEncounterByPerson(Person person) {

		return repo.findEncounterByPerson(person);
	}

//	public List<Branch> getBranchByEncounter(Encounter encounter) {
//
//		return repo.findBranchByEncounter(encounter);
//	}

}

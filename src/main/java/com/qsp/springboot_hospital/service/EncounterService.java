package com.qsp.springboot_hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.dao.BranchDao;
import com.qsp.springboot_hospital.dao.EncounterDao;
import com.qsp.springboot_hospital.dao.PersonDao;
import com.qsp.springboot_hospital.dto.Encounter;
import com.qsp.springboot_hospital.dto.MedOrder;
import com.qsp.springboot_hospital.dto.Branch;
import com.qsp.springboot_hospital.dto.Person;
import com.qsp.springboot_hospital.util.ResponseStructure;
@Service
public class EncounterService {
	
	
	@Autowired
	private EncounterDao encounterDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private BranchDao branchDao;
	
	ResponseStructure<Encounter> structure = new ResponseStructure<>();

	public ResponseStructure<Encounter> saveEncounter(Encounter encounter, int personId, int branchid) {
		// TODO Auto-generated method stub
		Person person=personDao.getPerson(personId);
		
		Branch branch=branchDao.getBranch(branchid);
		
		if(person!=null && branch!=null) {
			encounter.setPerson(person);
			
			List<Branch> branchs=new ArrayList<>();
			
			branchs.add(branch);
			
			encounter.setBranches(branchs);
			structure.setMessage("Encounter Saved Successfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(encounterDao.saveEncounter(encounter));

			
			return structure;
			
			
		}
		structure.setMessage("Encounter  Not saved missing values ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(null);

		return structure;

		
	}
	
	public ResponseStructure<Encounter> getEncounterById(int id) {
		Encounter encounter = encounterDao.getEncounter(id);

		if (encounter != null) {
			structure.setMessage("Encounter Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(encounter);

			return structure;
		}
		structure.setMessage("Encounter  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(encounter);

		return structure;

	}

	public ResponseStructure<Encounter> deleteEncounterById(int id) {
		Encounter encounter = encounterDao.getEncounter(id);

		if (encounter != null) {

			encounterDao.deleteEncounter(encounter);
			structure.setMessage("Encounter deleted Successfully ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(encounter);

			return structure;
		}
		structure.setMessage("Encounter  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(encounter);

		return structure;

	}

	public ResponseStructure<Encounter> updateEncounterById(int id, Encounter encounter) {
		Encounter encounter2 = encounterDao.getEncounter(id);

		if (encounter2 != null) {
			encounter.setEncounterId(id);
			encounterDao.saveEncounter(encounter);
			structure.setMessage("Encounter  Updated Successfully ");
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(encounter);

			return structure;
		}
		structure.setMessage("Encounter   Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(encounter2);

		return structure;
	}
	
	public ResponseStructure<List<Encounter>> getEncounterByPersonId(int personId) {
		ResponseStructure<List<Encounter>> structure = new ResponseStructure<>();

		Person person = personDao.getPerson(personId);

		if (person != null) {

			structure.setMessage("Branch Found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(encounterDao.getEncounterByPerson(person));
			return structure;
		}

		structure.setMessage("Branch Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(null);

		return structure;

	}

	
	
	
	

}

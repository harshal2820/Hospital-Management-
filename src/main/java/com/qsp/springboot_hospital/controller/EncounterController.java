package com.qsp.springboot_hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospital.dto.Encounter;
import com.qsp.springboot_hospital.service.EncounterService;
import com.qsp.springboot_hospital.util.ResponseStructure;

@RestController
@RequestMapping("/encounter")
public class EncounterController {
	
	@Autowired
	private EncounterService service;
	@PostMapping
	public ResponseStructure<Encounter> saveEncounter(@RequestBody Encounter encounter,@RequestParam int personId,@RequestParam int branchid) {
			
		return service.saveEncounter(encounter,personId,branchid);
		
	}
	@GetMapping
	public ResponseStructure<Encounter> getEncounterById(@RequestParam int id) {
		return service.getEncounterById(id);
	}
	@DeleteMapping
	public ResponseStructure<Encounter> deleteEncounterById(@RequestParam int id) {
		return service.deleteEncounterById(id);
	}
	@PutMapping
	public ResponseStructure<Encounter> updateEncounterById(@RequestParam int id,@RequestBody Encounter encounter) {
		return service.updateEncounterById(id, encounter);
	}
	@GetMapping("/getencounterbyperson")
	public ResponseStructure<List<Encounter>> getEncounterByPersonId(@RequestParam int personId) {
		return service.getEncounterByPersonId(personId);
	}
	

}

package com.qsp.springboot_hospital.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospital.dto.Person;
import com.qsp.springboot_hospital.service.PersonService;
import com.qsp.springboot_hospital.util.ResponseStructure;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService service;

	@PostMapping
	public ResponseStructure<Person> savePerson(@Valid @RequestBody Person person) {
		return service.savePerson(person);
	}
	@GetMapping
	public ResponseStructure<Person> getPersonById(@RequestParam int id) {
		return service.getPersonById(id);

	}
	@DeleteMapping
	public ResponseStructure<Person> deletePersonById(@RequestParam int id) {
		return service.deletePersonById(id);
	}
	@PutMapping
	public ResponseStructure<Person> updatePersonById(@RequestParam int id,@RequestBody Person person) {
		return service.updatePersonById(id, person);
	}
	@GetMapping("/getpersonbyphone")
	public ResponseStructure<Person> getPersonByPhone(@RequestParam long phone) {
		return service.getPersonByPhone(phone);
	}
	@GetMapping("/getpersonbyemail")
	public ResponseStructure<Person> getPersonByEmail(@RequestParam String email) {
		return service.getPersonByEmail(email);
	}
}

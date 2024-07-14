package com.qsp.springboot_hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.dao.PersonDao;
import com.qsp.springboot_hospital.dto.Person;

import com.qsp.springboot_hospital.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	ResponseStructure<Person> structure = new ResponseStructure<Person>();

	public ResponseStructure<Person> savePerson(Person person) {
		structure.setMessage("Person Saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(dao.savePerson(person));

		return structure;

	}
	

	public ResponseStructure<Person> getPersonById(int id) {
		Person person = dao.getPerson(id);

		if (person != null) {
			structure.setMessage("Person Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(person);

			return structure;
		}
		structure.setMessage("Person  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(person);

		return structure;

	}

	public ResponseStructure<Person> deletePersonById(int id) {
		Person person = dao.getPerson(id);

		if (person != null) {

			dao.deletePerson(person);
			structure.setMessage("Person deleted Successfully ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(person);

			return structure;
		}
		structure.setMessage("Person  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(person);

		return structure;

	}

	public ResponseStructure<Person> updatePersonById(int id, Person person) {
		Person person2 = dao.getPerson(id);

		if (person2 != null) {
			person.setPersonId(id);
			dao.savePerson(person);
			structure.setMessage("Person Updated Successfully ");
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(person);

			return structure;
		}
		structure.setMessage("Person  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(person2);

		return structure;
	}
		

	public ResponseStructure<Person> getPersonByPhone(long phone) {
		
		Person person = dao.getPersonByPhone(phone);

		if (person != null) {
			structure.setMessage("Person Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(person);

			return structure;
		}
		structure.setMessage("Person  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(person);

		return structure;
		

	}

	public ResponseStructure<Person> getPersonByEmail(String email) {
		
		Person person = dao.getPersonByEmail(email);

		if (person != null) {
			structure.setMessage("Person Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(person);

			return structure;
		}
		structure.setMessage("Person  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(person);

		return structure;
		

	}

}

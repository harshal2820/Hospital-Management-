package com.qsp.springboot_hospital.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.dto.Address;
import com.qsp.springboot_hospital.dto.Person;
import com.qsp.springboot_hospital.repo.PersonRepo;

@Repository
public class PersonDao {
	@Autowired
	private PersonRepo repo;

	public Person savePerson(Person person) {
		// TODO Auto-generated method stub
		return repo.save(person);
	}

	public Person getPerson(int personId) {
		// TODO Auto-generated method stub
		Optional<Person> optional = repo.findById(personId);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		repo.delete(person);
	}

	public Person getPersonByPhone(long phone) {

		return repo.findPersonByPhone(phone);
	}

	public Person getPersonByEmail(String email) {

		return repo.findPersonByPersonEmail(email);
	}

}

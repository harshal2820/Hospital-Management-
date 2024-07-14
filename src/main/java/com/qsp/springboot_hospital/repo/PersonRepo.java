package com.qsp.springboot_hospital.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospital.dto.Person;

public interface PersonRepo extends JpaRepository<Person,Integer> {
	
	
	Person findPersonByPhone(long phone);
	
	Person findPersonByPersonEmail(String email);

}

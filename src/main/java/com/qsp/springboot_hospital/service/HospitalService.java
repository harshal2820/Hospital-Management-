package com.qsp.springboot_hospital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.qsp.springboot_hospital.dao.HospitalDao;
import com.qsp.springboot_hospital.dto.Hospital;
import com.qsp.springboot_hospital.exception.HospitalIdNotFound;
import com.qsp.springboot_hospital.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {

		structure.setMessage("Hospital Saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(dao.saveHospital(hospital));

	
		return  new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		Hospital hospital = dao.getHospitalById(id);

		if (hospital != null) {
			structure.setMessage("Hospital Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(hospital);

			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new HospitalIdNotFound("Hospital id not found");
		
//		structure.setMessage("Hospital  Not Found ");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		structure.setData(hospital);
//
//		return structure;
		}
	}

	public ResponseStructure<Hospital> deleteHospitalById(int id) {
		Hospital hospital = dao.deleteHospitalById(id);

		if (hospital != null) {
			structure.setMessage("Hospital deleted Successfully ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(hospital);

			return structure;
		}
		structure.setMessage("Hospital  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(hospital);

		return structure;
	}

	public ResponseStructure<Hospital> updateHospitalById(int id, Hospital hospital) {
		// TODO Auto-generated method stub
		Hospital hospital1 = dao.updateHospitalById(id, hospital);

		if (hospital1 != null) {
			structure.setMessage("Hospital Updated Successfully ");
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(hospital1);

			return structure;
		}
		structure.setMessage("Hospital  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(hospital1);

		return structure;
	}

	public ResponseStructure<Hospital> getHospitalByEmail(String email) {

		Hospital hospital = dao.getHospitalByEmail(email);

		if (hospital != null) {
			structure.setMessage("Hospital Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(hospital);

			return structure;
		}

		structure.setMessage("Hospital  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(hospital);

		return structure;

	}

}

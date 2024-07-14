package com.qsp.springboot_hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.dao.EncounterDao;
import com.qsp.springboot_hospital.dao.MedOrderDao;
import com.qsp.springboot_hospital.dto.Address;
import com.qsp.springboot_hospital.dto.Branch;
import com.qsp.springboot_hospital.dto.Encounter;
import com.qsp.springboot_hospital.dto.Hospital;
import com.qsp.springboot_hospital.dto.MedOrder;
import com.qsp.springboot_hospital.util.ResponseStructure;

@Service
public class MedOrderService {
	
	@Autowired
	private MedOrderDao medOrderDao;
	@Autowired
	private EncounterDao encounterDao;

	ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();

	public ResponseStructure<MedOrder> saveMedOrder(MedOrder medOrder, int encounterId) {
		Encounter encounter = encounterDao.getEncounter(encounterId);

		if (encounter != null) {
			medOrder.setEncounter(encounter);

			structure.setMessage("MedOrder Saved");
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(medOrderDao.saveMedOrder(medOrder));

			return structure;
		}
		structure.setMessage("MedOrder not Saved");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(null);

		return structure;
	}

	public ResponseStructure<List<MedOrder>> getMedOrderByEncounterId(int encounterId) {
		ResponseStructure<List<MedOrder>> structure = new ResponseStructure<>();

		Encounter encounter = encounterDao.getEncounter(encounterId);

		if (encounter != null) {

			structure.setMessage("MedOrder Found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(medOrderDao.getMedOrderByEncounter(encounter));
			return structure;
		}

		structure.setMessage("MedOrder Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(null);

		return structure;

	}

	public ResponseStructure<MedOrder> getMedOrderById(int medOrderId) {
		MedOrder medOrder = medOrderDao.getMedOrderById(medOrderId);

		if (medOrder != null) {
			structure.setMessage("MedOrder Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(medOrder);

			return structure;
		}
		structure.setMessage("MedOrder  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(medOrder);

		return structure;

	}

	public ResponseStructure<MedOrder> deleteMedOrderById(int medOrderId) {

		MedOrder medOrder = medOrderDao.getMedOrderById(medOrderId);

		if (medOrder != null) {

			medOrderDao.deleteMedOrder(medOrder);
			structure.setMessage("MedOrder deleted Successfully ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(medOrder);

			return structure;
		}
		structure.setMessage("MedOrder  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(medOrder);

		return structure;
	}

	public ResponseStructure<MedOrder> updateMedOrder(int medOrderId, MedOrder medOrder) {
		
		MedOrder medOrder1 = medOrderDao.getMedOrderById(medOrderId);

		if (medOrder1 != null) {
			medOrder.setMedOrderId(medOrderId);
			medOrderDao.saveMedOrder(medOrder);
			structure.setMessage("MedOrder Updated Successfully ");
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(medOrder);

			return structure;
		}
		structure.setMessage("MedOrder  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(medOrder1);

		return structure;

	}
	public ResponseStructure<List<MedOrder>> getMedOrderByDoctor(String doctor) {
		ResponseStructure<List<MedOrder>> structure = new ResponseStructure<>();

		List<MedOrder> medOrders= medOrderDao.getMedOrderByDoctor(doctor);

		if (!(medOrders.isEmpty())) {

			structure.setMessage("MedOrder Found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(medOrders);
			return structure;
		}

		structure.setMessage("MedOrder Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(medOrders);

		return structure;

	}

	
	
		
	
}

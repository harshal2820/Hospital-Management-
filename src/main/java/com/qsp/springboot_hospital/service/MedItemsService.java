package com.qsp.springboot_hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.dao.MedItemsDao;
import com.qsp.springboot_hospital.dao.MedOrderDao;
import com.qsp.springboot_hospital.dto.MedItems;
import com.qsp.springboot_hospital.dto.MedOrder;
import com.qsp.springboot_hospital.util.ResponseStructure;

@Service
public class MedItemsService {
	
	@Autowired
	private MedItemsDao  medItemsDao;
	@Autowired
	private MedOrderDao  medOrderDao;

	ResponseStructure<MedItems> structure = new ResponseStructure<MedItems>();

	public ResponseStructure<MedItems> saveMedItems(MedItems medItems, int medOrderId) {
		MedOrder medOrder = medOrderDao.getMedOrderById(medOrderId);

		if (medOrder != null) {
			medItems.setMedOrder(medOrder);
			//message
			structure.setMessage("MedItems Saved");
			//status
			structure.setStatusCode(HttpStatus.CREATED.value()); 
			//T data
			structure.setData(medItemsDao.saveMedItems(medItems));

			return structure;
		}
		structure.setMessage("MedItems not Saved");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(null);

		return structure;
	}

	public ResponseStructure<List<MedItems>> getMedItemsByMedOrderId(int medOrderId) {
		ResponseStructure<List<MedItems>> structure = new ResponseStructure<>();

		MedOrder medOrder = medOrderDao.getMedOrderById(medOrderId);

		if (medOrder != null) {

			structure.setMessage("MedItems Found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(medItemsDao.getMedItemsByMedOrder(medOrder));
			return structure;
		}

		structure.setMessage("MedItems Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(null);

		return structure;

	}

	public ResponseStructure<MedItems> getMedItemsById(int medItemsId) {
		MedItems medItems = medItemsDao.getMedItemsById(medItemsId);

		if (medItems != null) {
			structure.setMessage("MedItems Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(medItems);

			return structure;
		}
		structure.setMessage("MedItems  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(medItems);

		return structure;

	}

	public ResponseStructure<MedItems> deleteMedItemsById(int medItemsId) {

		MedItems medItems = medItemsDao.getMedItemsById(medItemsId);

		if (medItems != null) {

			medItemsDao.deleteMedItems(medItems);
			structure.setMessage("MedItems deleted Successfully ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(medItems);

			return structure;
		}
		structure.setMessage("MedItems  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(medItems);

		return structure;
	}

	public ResponseStructure<MedItems> updateMedItems(int medItemsId, MedItems medItems) {
		
		MedItems medItems1 = medItemsDao.getMedItemsById(medItemsId);

		if (medItems1 != null) {
			medItems.setMedItemsId(medItemsId);
			medItemsDao.saveMedItems(medItems);
			structure.setMessage("MedItems Updated Successfully ");
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(medItems);

			return structure;
		}
		structure.setMessage("MedItems  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(medItems1);

		return structure;

	}


}

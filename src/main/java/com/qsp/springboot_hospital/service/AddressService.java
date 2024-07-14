package com.qsp.springboot_hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.dao.AddressDao;
import com.qsp.springboot_hospital.dto.Address;

import com.qsp.springboot_hospital.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	
	ResponseStructure<Address> structure = new ResponseStructure<Address>();

	public ResponseStructure<Address> saveAddress(Address address) {

		structure.setMessage("Address Saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(dao.saveAddress(address));

		return structure;

	}

	public ResponseStructure<Address> getAddressById(int id) {
		Address address = dao.getAddressById(id);

		if (address != null) {
			structure.setMessage("Address Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(address);

			return structure;
		}
		structure.setMessage("Address  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(address);

		return structure;

	}

	public ResponseStructure<Address> deleteAddressById(int id) {
		Address address = dao.getAddressById(id);

		if (address != null) {

			dao.deleteAddress(address);
			structure.setMessage("Address deleted Successfully ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(address);

			return structure;
		}
		structure.setMessage("Address  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(address);

		return structure;

	}

	public ResponseStructure<Address> updateAddressById(int id, Address address) {
		Address address2 = dao.getAddressById(id);

		if (address2 != null) {
			address.setAddressId(id);
			dao.saveAddress(address);
			structure.setMessage("Address Updated Successfully ");
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(address);

			return structure;
		}
		structure.setMessage("Address  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(address2);

		return structure;
	}
		

	public ResponseStructure<Address> getAddressByPincode(int pincode) {
		
		Address address = dao.getAddressByPincode(pincode);

		if (address != null) {
			structure.setMessage("Address Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(address);

			return structure;
		}
		structure.setMessage("Address  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(address);

		return structure;
		

	}

}

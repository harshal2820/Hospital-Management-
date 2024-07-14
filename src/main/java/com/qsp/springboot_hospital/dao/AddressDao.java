package com.qsp.springboot_hospital.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospital.dto.Address;
import com.qsp.springboot_hospital.repo.AddressRepo;
@Repository
public class AddressDao {
	
	@Autowired
	private AddressRepo repo;

	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return repo.save(address);
	}

	public Address getAddressById(int id) {
		// TODO Auto-generated method stub
		Optional<Address> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	

	

	public void deleteAddress(Address address) {
		// TODO Auto-generated method stub
		repo.delete(address);
	}
	
	public Address getAddressByPincode(int pincode) {
		
		return repo.findAddressByPincode(pincode);
		
	}
	
	
	
	

	

}

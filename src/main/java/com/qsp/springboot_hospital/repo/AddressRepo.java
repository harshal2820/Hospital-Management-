package com.qsp.springboot_hospital.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospital.dto.Address;

public interface AddressRepo  extends JpaRepository<Address, Integer>{
	
	Address  findAddressByPincode(int pincode);

}

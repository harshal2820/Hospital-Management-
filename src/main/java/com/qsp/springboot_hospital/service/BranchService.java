package com.qsp.springboot_hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospital.dao.AddressDao;
import com.qsp.springboot_hospital.dao.BranchDao;
import com.qsp.springboot_hospital.dao.HospitalDao;
import com.qsp.springboot_hospital.dto.Address;
import com.qsp.springboot_hospital.dto.Branch;
import com.qsp.springboot_hospital.dto.Hospital;
import com.qsp.springboot_hospital.util.ResponseStructure;

@Service
public class BranchService {
	
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;

	ResponseStructure<Branch> structure = new ResponseStructure<Branch>();

	public ResponseStructure<Branch> saveBranch(int hospitalId, int addressId, Branch branch) {
		// TODO Auto-generated method stub
		Hospital hospital = hospitalDao.getHospitalById(hospitalId);

		Address address = addressDao.getAddressById(addressId);

		if (hospital != null && address != null) {
			branch.setHospital(hospital);
			branch.setAddress(address);

			structure.setMessage("Branch Saved");
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(branchDao.saveBranch(branch));

			return structure;
		}
		structure.setMessage("Branch Not Saved");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(null);

		return structure;

	}

	public ResponseStructure<List<Branch>> getBranchByHospital(int hospitalId) {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<>();

		Hospital hospital = hospitalDao.getHospitalById(hospitalId);

		if (hospital != null) {

			structure.setMessage("Branch Found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(branchDao.getBranchByHospital(hospital));
			return structure;
		}

		structure.setMessage("Branch Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(null);

		return structure;

	}

	public ResponseStructure<Branch> getBranchById(int branchId) {
		Branch branch = branchDao.getBranch(branchId);

		if (branch != null) {
			structure.setMessage("Branch Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(branch);

			return structure;
		}
		structure.setMessage("Branch  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(branch);

		return structure;

	}

	public ResponseStructure<Branch> deleteBranchById(int branchId) {

		Branch branch = branchDao.getBranch(branchId);

		if (branch != null) {

			branchDao.deleteBranch(branch);
			structure.setMessage("Branch deleted Successfully ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(branch);

			return structure;
		}
		structure.setMessage("Branch  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(branch);

		return structure;

	}

	public ResponseStructure<Branch> updateBranch(int branchid, Branch branch) {
		Branch branch1 = branchDao.getBranch(branchid);

		if (branch1 != null) {
			branch.setBranchId(branchid);
			branchDao.saveBranch(branch);
			structure.setMessage("Branch Updated Successfully ");
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setData(branch);

			return structure;
		}
		structure.setMessage("Branch  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(branch1);

		return structure;

	}

	public ResponseStructure<Branch> getBranchByAddressId(int addressId) {
		Address address = addressDao.getAddressById(addressId);

		if (address != null) {
			structure.setMessage("Branch Found Successfully ");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(branchDao.getbranchByAddress(address));

			return structure;
		}
		structure.setMessage("Branch  Not Found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setData(null);

		return structure;

	}

}

package com.qsp.springboot_hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospital.dto.MedItems;
import com.qsp.springboot_hospital.service.MedItemsService;
import com.qsp.springboot_hospital.util.ResponseStructure;
@RestController
@RequestMapping("/meditems")
public class MedItemsController {
	@Autowired
	private MedItemsService  service;
	@PostMapping
	public ResponseStructure<MedItems> saveMedItems(@RequestBody MedItems medItems,@RequestParam int medOrderId) {
		return service.saveMedItems(medItems, medOrderId);
	}
	@GetMapping("/getmeditemsbyorderid")
	public ResponseStructure<List<MedItems>> getMedItemsByMedOrderId(@RequestParam int medOrderId) {
		return service.getMedItemsByMedOrderId(medOrderId);
	}
	@GetMapping
	public ResponseStructure<MedItems> getMedItemsById(@RequestParam int medItemsId) {
		return service.getMedItemsById(medItemsId);
	}
	@DeleteMapping
	public ResponseStructure<MedItems> deleteMedItemsById(@RequestParam int medItemsId) {
		return service.deleteMedItemsById(medItemsId);
	}
	@PutMapping
	public ResponseStructure<MedItems> updateMedItems(@RequestParam int medItemsId,@RequestBody MedItems medItems) {
		return service.updateMedItems(medItemsId, medItems);
	}
		

}

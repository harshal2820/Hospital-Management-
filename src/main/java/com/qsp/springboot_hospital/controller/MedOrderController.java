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

import com.qsp.springboot_hospital.dto.MedOrder;
import com.qsp.springboot_hospital.service.MedOrderService;

import com.qsp.springboot_hospital.util.ResponseStructure;

@RestController
@RequestMapping("/medorder")
public class MedOrderController {
		@Autowired
		private MedOrderService service;
		
		@PostMapping
		public ResponseStructure<MedOrder> saveMedOrder(@RequestBody MedOrder medOrder,@RequestParam int encounterId) {
			return service.saveMedOrder(medOrder, encounterId);
		}
		@GetMapping("/getmedorderbyencounter")
		public ResponseStructure<List<MedOrder>> getMedOrderByEncounterId(@RequestParam int encounterId) {
			return service.getMedOrderByEncounterId(encounterId);
		}
		@GetMapping
		public ResponseStructure<MedOrder> getMedOrderById(@RequestParam int medOrderId) {
			return service.getMedOrderById(medOrderId);
		}
		@DeleteMapping
		public ResponseStructure<MedOrder> deleteMedOrderById(@RequestParam int medOrderId) {
			return service.deleteMedOrderById(medOrderId);
		}
		@PutMapping
		public ResponseStructure<MedOrder> updateMedOrder(@RequestParam int medOrderId,@RequestBody MedOrder medOrder) {
			return service.updateMedOrder(medOrderId, medOrder);
		}
}

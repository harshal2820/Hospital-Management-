package com.qsp.springboot_hospital.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospital.dto.MedItems;
import com.qsp.springboot_hospital.dto.MedOrder;

public interface MedItemsRepo extends JpaRepository<MedItems,Integer>{

	List<MedItems> findMedItemsByMedOrder(MedOrder medOrder);

}

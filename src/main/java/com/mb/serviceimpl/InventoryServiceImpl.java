package com.mb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.model.Inventory;
import com.mb.repo.InventoryRepository;
import com.mb.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	InventoryRepository inventoryrepository;

	@Override
	public String addInventory(Inventory inventory) {
		if(inventory!=null) {
			inventoryrepository.addInventory(inventory);
			 return "success";
			}else {
				return "failure";
			}
	}

	@Override
	public String updateInventory(Inventory inventory) {
		inventoryrepository.updtae(inventory);
		System.out.println("Inventory service");
		return "Success";
	}

	@Override
	public String deleteInventory(int id) {
		return inventoryrepository.delete(id);
	}

	@Override
	public List<Inventory> findAllInventories() {
		return inventoryrepository.findAllInventories();
	}

	@Override
	public Inventory findInventoryById(int id) {
		return inventoryrepository.findById(id);
	}

}

package com.mb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mb.model.Inventory;
import com.mb.serviceimpl.InventoryServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
	InventoryServiceImpl inventroyserviceimpl;
	@PostMapping
	public String insertInventory(@RequestBody Inventory inventory) {
		String msg="";
		try {
			inventroyserviceimpl.addInventory(inventory);
			msg="Success";
		}
		catch(Exception e) {
			msg="Failure";
		}
		return msg;
		
	}
	@GetMapping("{inventoryId}")
	public Inventory getInventoryById(@PathVariable("inventoryId") int id) {
		return inventroyserviceimpl.findInventoryById(id);
		
	}
	@GetMapping("/all")
	public List<Inventory> getInventories(){
		return inventroyserviceimpl.findAllInventories();
	}
	
	@PutMapping
	public String updateInventory(@RequestBody Inventory inventory) {
		String msg="";
		try {
			inventroyserviceimpl.updateInventory(inventory);
			msg="Updated";
		}
		catch(Exception e) {
			msg="Not Updated";
		}
		return msg;
		
	}
	@DeleteMapping("{inventoryId}")
	public String deleteInventory(@PathVariable("inventoryId") int id) {
		String msg="";
		try {
			inventroyserviceimpl.deleteInventory(id);
			msg="Deleted";
		}
		catch(Exception e) {
			msg="Not Deleted";
		}
		return msg;
	}
	
	

}

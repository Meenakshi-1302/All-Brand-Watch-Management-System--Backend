package com.mb.service;

import java.util.List;

import com.mb.model.Inventory;


public interface InventoryService {
	public String addInventory(Inventory inventory);
	public String updateInventory(Inventory inventory);
	public String deleteInventory(int id);
	public List<Inventory> findAllInventories();
	public Inventory findInventoryById(int id);

}

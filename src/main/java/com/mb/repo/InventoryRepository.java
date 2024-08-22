package com.mb.repo;

import java.util.List;

import com.mb.model.Inventory;

public interface InventoryRepository {
	public String addInventory(Inventory inventory);
	public String updtae(Inventory inventory);
	public String delete(int inventoryId);
	public List<Inventory> findAllInventories();
	public Inventory findById(int inventoryId);

}

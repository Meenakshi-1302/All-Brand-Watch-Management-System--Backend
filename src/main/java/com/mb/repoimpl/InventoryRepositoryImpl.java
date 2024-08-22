package com.mb.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mb.model.Inventory;
import com.mb.repo.InventoryRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class InventoryRepositoryImpl implements InventoryRepository {
	
	@Autowired
	EntityManager entitymanager;

	@Override
	public String addInventory(Inventory inventory) {
		if(inventory!=null) {
			entitymanager.merge(inventory);
			return "success";
			}
			else {
				return "insertion failed";
			}
	}

	@Override
	public String updtae(Inventory inventory) {
		if(inventory!=null) {
			entitymanager.merge(inventory);
			return"success";
		}
		else {
			return "failure";
		}
	}

	@Override
	public String delete(int inventoryId) {
		Inventory id = entitymanager.find(Inventory.class,inventoryId);
		entitymanager.remove(id);
		return "deleted";
	}

	@Override
	public List<Inventory> findAllInventories() {
		String hql = "from Inventory";
		Query query = entitymanager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Inventory findById(int inventoryId) {
		return entitymanager.find(Inventory.class, inventoryId);
	}
	
	

}

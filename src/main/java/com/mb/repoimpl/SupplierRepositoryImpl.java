package com.mb.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mb.model.Supplier;
import com.mb.model.Watch;
import com.mb.repo.SupplierRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SupplierRepositoryImpl implements SupplierRepository {
	
	@Autowired
	EntityManager entitymanager;

	@Override
	public String addSupplier(Supplier supplier) {
		if(supplier!=null) {
			entitymanager.merge(supplier);
			return "success";
			}
			else {
				return "insertion failed";
			}
	}

	@Override
	public String update(Supplier supplier) {
		if(supplier!=null) {
			entitymanager.merge(supplier);
			return"success";
		}
		else {
			return "failure";
		}
	}

	@Override
	public String delete(int supplierId) {
		Supplier id = entitymanager.find(Supplier.class,supplierId);
		entitymanager.remove(id);
		return "deleted";
	}

	@Override
	public List<Supplier> findAllSuppliers() {
		String hql = "from Supplier";
		Query query = entitymanager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Supplier findById(int supplierId) {
		return entitymanager.find(Supplier.class, supplierId);
	}

}

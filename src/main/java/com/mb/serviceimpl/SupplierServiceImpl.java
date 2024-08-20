package com.mb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.model.Supplier;
import com.mb.repo.SupplierRepository;
import com.mb.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierRepository supplierrepository;
	@Override
	public String addSupplier(Supplier supplier) {
		if(supplier!=null) {
			supplierrepository.addSupplier(supplier);
			 return "success";
			}else {
				return "failure";
			}
	}

	@Override
	public String updateSupplier(Supplier supplier) {
		supplierrepository.update(supplier);
		System.out.println("Supplier service");
		return "Success";
	}

	@Override
	public String deleteSupplier(int id) {
		return supplierrepository.delete(id);
	}

	@Override
	public List<Supplier> findAllSuppliers() {
		return supplierrepository.findAllSuppliers();
	}

	@Override
	public Supplier findSupplerById(int id) {
		return supplierrepository.findById(id);
	}

}

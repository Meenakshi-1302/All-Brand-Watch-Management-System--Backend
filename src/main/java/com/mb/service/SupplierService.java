package com.mb.service;

import java.util.List;

import com.mb.model.Supplier;


public interface SupplierService {
	public String addSupplier(Supplier supplier);
	public String updateSupplier(Supplier supplier);
	public String deleteSupplier(int id);
	public List<Supplier> findAllSuppliers();
	public Supplier findSupplerById(int id);

}

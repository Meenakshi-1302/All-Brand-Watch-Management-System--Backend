package com.mb.repo;

import java.util.List;

import com.mb.model.Supplier;



public interface SupplierRepository {
	public String addSupplier(Supplier watch);
	public String update(Supplier watch);
	public String delete(int supplierId );
	public List<Supplier> findAllSuppliers();
	public Supplier findById(int supplierId);

}

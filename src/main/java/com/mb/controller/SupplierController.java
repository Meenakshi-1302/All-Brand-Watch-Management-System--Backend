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
import com.mb.model.Supplier;
import com.mb.serviceimpl.SupplierServiceImpl;

@RestController
@RequestMapping("/supplier")
@CrossOrigin("*")
public class SupplierController {
	@Autowired
	SupplierServiceImpl supplierserviceimpl;
	@PostMapping
	public String insertSupplier(@RequestBody Supplier supplier) {
		String msg="";
		try {
			supplierserviceimpl.addSupplier(supplier);
			msg="Success";
		}
		catch(Exception e) {
			msg="Failure";
		}
		return msg;
		
	}
	@GetMapping("{supplierId}")
	public Supplier getSupplierById(@PathVariable("supplierId") int id) {
		return supplierserviceimpl.findSupplerById(id);
		
	}
	@GetMapping("/all")
	public List<Supplier> getSuppliers(){
		return supplierserviceimpl.findAllSuppliers();
	}
	
	@PutMapping
	public String updateSupplier(@RequestBody Supplier supplier) {
		String msg="";
		try {
			supplierserviceimpl.updateSupplier(supplier);
			msg="Updated";
		}
		catch(Exception e) {
			msg="Not Updated";
		}
		return msg;
		
	}
	@DeleteMapping("{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int id) {
		String msg="";
		try {
			supplierserviceimpl.deleteSupplier(id);
			msg="Deleted";
		}
		catch(Exception e) {
			msg="Not Deleted";
		}
		return msg;
	}
	

}

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mb.model.ProductList;
import com.mb.serviceimpl.ProductListServiceImpl;


@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductListController {
	@Autowired
	ProductListServiceImpl productlistserviceimpl;
	
	@PostMapping
	public String insertProduct(@RequestBody ProductList product) {
		
			productlistserviceimpl.addProduct(product);
			return "Success";
		
	}
	
	@GetMapping("{productId}")
	public ProductList getProductById(@PathVariable("productId") int id) {
		return productlistserviceimpl.findProductById(id);
		
	}
	
	@GetMapping("/all")
	public List<ProductList> getProducts(){
		return productlistserviceimpl.findAllProducts();
	}
	
	@PutMapping
	public String updateProduct(@RequestBody ProductList product) {
		String msg="";
		try {
			productlistserviceimpl.updateProduct(product);
			msg="Updated";
		}
		catch(Exception e) {
			msg="Not Updated";
		}
		return msg;
		
	}
	@DeleteMapping("{productId}")
	public String deleteProduct(@PathVariable("productList") int id) {
		String msg="";
		try {
			productlistserviceimpl.deleteProduct(id);
			msg="Deleted";
		}
		catch(Exception e) {
			msg="Not Deleted";
		}
		return msg;
	}

}

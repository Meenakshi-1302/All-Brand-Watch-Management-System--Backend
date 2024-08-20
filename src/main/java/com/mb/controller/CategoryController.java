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
import com.mb.model.Category;
import com.mb.serviceimpl.CategoryServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryServiceImpl categoryserviceimpl;
	@PostMapping
	public String insertWatch(@RequestBody Category category) {
		String msg="";
		try {
			categoryserviceimpl.addCategory(category);
			msg="Success";
		}
		catch(Exception e) {
			msg="Failure";
		}
		return msg;
		
	}
	@GetMapping("{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId") int id) {
		return categoryserviceimpl.findCategoryById(id);
		
	}
	@GetMapping("/all")
	public List<Category> getWatches(){
		return categoryserviceimpl.findAllCategories();
	}
	
	@PutMapping
	public String updateCategory(@RequestBody Category category) {
		String msg="";
		try {
			categoryserviceimpl.updateCategory(category);
			msg="Updated";
		}
		catch(Exception e) {
			msg="Not Updated";
		}
		return msg;
		
	}
	@DeleteMapping("{categoryId}")
	public String deleteWatch(@PathVariable("categoryId") int id) {
		String msg="";
		try {
			categoryserviceimpl.deleteCategory(id);
			msg="Deleted";
		}
		catch(Exception e) {
			msg="Not Deleted";
		}
		return msg;
	}

	
	

}

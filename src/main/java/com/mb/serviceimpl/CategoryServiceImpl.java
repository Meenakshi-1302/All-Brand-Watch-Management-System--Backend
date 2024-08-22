package com.mb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.model.Category;
import com.mb.repo.CategoryRepository;
import com.mb.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryrepository;
	
	@Override
	public String addCategory(Category category) {
		if(category!=null) {
			categoryrepository.addCategory(category);
			 return "success";
			}else {
				return "failure";
			}
	}

	@Override
	public String updateCategory(Category category) {
		categoryrepository.update(category);
		System.out.println("Category service");
		return "Success";
	}

	@Override
	public String deleteCategory(int id) {
		return categoryrepository.delete(id);
	}

	@Override
	public List<Category> findAllCategories() {
		return categoryrepository.findAllCategories();
	}

	@Override
	public Category findCategoryById(int id) {
		return categoryrepository.findById(id);
	}

}

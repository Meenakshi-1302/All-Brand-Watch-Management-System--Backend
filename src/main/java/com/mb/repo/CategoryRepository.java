package com.mb.repo;

import java.util.List;

import com.mb.model.Category;



public interface CategoryRepository {
	public String addCategory(Category category);
	public String update(Category category);
	public String delete(int categoryId);
	public List<Category> findAllCategories();
	public Category findById(int categoryId);
	
}

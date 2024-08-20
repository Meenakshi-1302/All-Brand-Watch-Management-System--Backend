package com.mb.service;

import java.util.List;

import com.mb.model.Category;

public interface CategoryService {
	public String addCategory(Category category);
	public String updateCategory(Category category);
	public String deleteCategory(int id);
	public List<Category> findAllCategories();
	public Category findCategoryById(int id);

}

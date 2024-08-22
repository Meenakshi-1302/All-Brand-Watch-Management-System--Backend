package com.mb.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mb.model.Category;
import com.mb.model.Inventory;
import com.mb.repo.CategoryRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {
	
	@Autowired
	EntityManager entitymanager;
	
	@Override
	public String addCategory(Category category) {
		if(category!=null) {
			entitymanager.merge(category);
			return "success";
			}
			else {
				return "insertion failed";
			}
	}

	@Override
	public String update(Category category) {
		if(category!=null) {
			entitymanager.merge(category);
			return "success";
			}
			else {
				return "insertion failed";
			}
	}

	@Override
	public String delete(int categoryId) {
		Category id = entitymanager.find(Category.class,categoryId);
		entitymanager.remove(id);
		return "deleted";
	}

	@Override
	public List<Category> findAllCategories() {
		String hql = "from Category";
		Query query = entitymanager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Category findById(int categoryId) {
		return entitymanager.find(Category.class, categoryId);
	}

}

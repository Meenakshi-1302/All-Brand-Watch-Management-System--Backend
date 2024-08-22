package com.mb.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mb.model.ProductList;
import com.mb.model.Supplier;
import com.mb.repo.ProductListRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class ProductListRepositoryImpl implements ProductListRepository {

	@Autowired
	EntityManager entitymanager;
	
	@Override
	public String addProduct(ProductList product) {
		entitymanager.persist(product);
		return "";
	}

	@Override
	public String update(ProductList product) {
		if(product!=null) {
			entitymanager.merge(product);
			return"success";
		}
		else {
			return "failure";
		}
	}

	@Override
	public String delete(int productId) {
		ProductList id = entitymanager.find(ProductList.class,productId);
		entitymanager.remove(id);
		return "deleted";
	}

	@Override
	public List<ProductList> findAllProducts() {
		String hql = "from ProductList";
		Query query = entitymanager.createQuery(hql);
		return query.getResultList();
		
	}

	@Override
	public ProductList findById(int productId) {
		return entitymanager.find(ProductList.class, productId);
	}

}

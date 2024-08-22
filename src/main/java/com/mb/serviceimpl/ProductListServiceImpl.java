package com.mb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.model.ProductList;
import com.mb.repo.ProductListRepository;
import com.mb.service.ProductListService;

@Service
public class ProductListServiceImpl implements ProductListService {
	@Autowired
	ProductListRepository productlistrepository;

	@Override
	public String addProduct(ProductList product) {
		if(product!=null) {
			productlistrepository.addProduct(product);
			 return "success";
			}else {
				return "failure";
			}
	}

	@Override
	public String updateProduct(ProductList product) {
		productlistrepository.update(product);
		System.out.println("Product service");
		return "Success";
	}

	@Override
	public String deleteProduct(int id) {
		return productlistrepository.delete(id);
	}

	@Override
	public List<ProductList> findAllProducts() {
		return productlistrepository.findAllProducts();
	}

	@Override
	public ProductList findProductById(int id) {
		return productlistrepository.findById(id);
	}

}

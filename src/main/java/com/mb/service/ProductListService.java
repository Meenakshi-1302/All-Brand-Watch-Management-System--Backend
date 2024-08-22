package com.mb.service;

import java.util.List;

import com.mb.model.ProductList;


public interface ProductListService {
	public String addProduct(ProductList product);
	public String updateProduct(ProductList product);
	public String deleteProduct(int id);
	public List<ProductList> findAllProducts();
	public ProductList findProductById(int id);

}

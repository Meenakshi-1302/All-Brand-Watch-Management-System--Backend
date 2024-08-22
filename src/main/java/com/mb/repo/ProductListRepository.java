package com.mb.repo;

import java.util.List;

import com.mb.model.ProductList;


public interface ProductListRepository {
	public String addProduct(ProductList product);
	public String update(ProductList product);
	public String delete(int productId );
	public List<ProductList> findAllProducts();
	public ProductList findById(int ProductId);

}

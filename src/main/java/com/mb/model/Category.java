package com.mb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	@Column(name="Category Name")
	private String name;
	@Column(name="Description")
	private String description;
	@ManyToOne
	@JoinColumn(name = "productId") // Foreign key column
	private ProductList product;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int categoryId, String name, String description) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public Category(int categoryId, String name, String description, ProductList product) {
//		super();
//		this.categoryId = categoryId;
//		this.name = name;
//		this.description = description;
//		this.product = product;
//	}
//	public int getCategoryId() {
//		return categoryId;
//	}
//	public void setCategoryId(int categoryId) {
//		this.categoryId = categoryId;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public ProductList getProduct() {
//		return product;
//	}
//	public void setProduct(ProductList product) {
//		this.product = product;
//	}
	
	
	

}

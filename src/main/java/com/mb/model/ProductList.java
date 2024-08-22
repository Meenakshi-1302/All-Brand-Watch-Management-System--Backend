package com.mb.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productList")
public class ProductList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@OneToOne 
    @JoinColumn(name = "watch_id", referencedColumnName = "watch_id") 
    private Watch watch;
	
	@OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> categories;
	public ProductList() {
		super();
	}
	public ProductList(int productId, Watch watch, List<Category> categories) {
		super();
		this.productId = productId;
		this.watch = watch;
		this.categories = categories;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Watch getWatch() {
		return watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
//	public List<Feedback> getFeedback() {
//		return feedback;
//	}
//	public void setFeedback(List<Feedback> feedback) {
//		this.feedback = feedback;
//	}
		

	
	
	
	
	
	
//	product id, watch(name,price,),category(name),feedback(rating,feedback)
//                one to one         one to many        one to many
}

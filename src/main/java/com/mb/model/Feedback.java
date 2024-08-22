package com.mb.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	 @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Customer> customers = new ArrayList<>();
	 @Column(name="Feedback", length=500)
	private String feedback;
	 @Column(name="Rating")
	private double rating;
	@ManyToOne
		@JoinColumn(name = "productId") // Foreign key column
		private ProductList product;
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(int feedbackId, List<Customer> customers, String feedback, double rating, ProductList product) {
		super();
		this.feedbackId = feedbackId;
		this.customers = customers;
		this.feedback = feedback;
		this.rating = rating;
		this.product = product;
	}
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public ProductList getProduct() {
		return product;
	}
	public void setProduct(ProductList product) {
		this.product = product;
	}
	
	 
	 

}

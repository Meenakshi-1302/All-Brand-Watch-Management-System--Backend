package com.mb.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="Watch_tbl")
public class Watch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int watch_id;
	@Column(name="Brand ID")
	private int brand_id;
	@Column(name="Model Number")
	private String model_number;
	@Column(name="WatchName")
	private String name;
	@Column(name="Description")
	private String description;
	@Column(name="Price")
	private double price;
	@Column(name="Stock Quantity")
	private int stock_quantity;
	@Column(name="Category")
	private String category;
	
	@Lob
    @Column(name="ImageUrl",length=1000000000)
    private byte[] imageUrl;
	
	public Watch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Watch(int watch_id, int brand_id, String model_number, String name, String description, double price,
			int stock_quantity, String category, byte[] imageUrl) {
		super();
		this.watch_id = watch_id;
		this.brand_id = brand_id;
		this.model_number = model_number;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock_quantity = stock_quantity;
		this.category = category;
		this.imageUrl = imageUrl;
	}

	public int getWatch_id() {
		return watch_id;
	}
	public void setWatch_id(int watch_id) {
		this.watch_id = watch_id;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getModel_number() {
		return model_number;
	}
	public void setModel_number(String model_number) {
		this.model_number = model_number;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public String getCategory() {
		return category;
	}
	public byte[] getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(byte[] imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
	
	

}

package com.mb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Supplier") 
public class Supplier { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long supplierId; 
    @Column(name="Supplier Name")
    private String name; 
    @Column(name="Contact Information")
    private String contactInfo; 
    @Column(name="Address")
    private String address;
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(Long supplierId, String name, String contactInfo, String address) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.contactInfo = contactInfo;
		this.address = address;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	} 
    

  

   

} 

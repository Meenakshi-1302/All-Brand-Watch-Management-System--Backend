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
@Table(name = "Inventory") 
public class Inventory { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long inventoryId; 
    
    @ManyToOne 
    @JoinColumn(name = "watch_id", referencedColumnName = "watch_id") 
    private Watch watch; 
    @ManyToOne 
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplierId") 
    private Supplier supplier; 
    @Column(name="Quantiy Received")
    private Integer quantityReceived; 
    @Column(name="Received At")
    private String receivedAt;
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(Long inventoryId, Watch watch, Supplier supplier, Integer quantityReceived,
			String receivedAt) {
		super();
		this.inventoryId = inventoryId;
		this.watch = watch;
		this.supplier = supplier;
		this.quantityReceived = quantityReceived;
		this.receivedAt = receivedAt;
	}
	public Long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public Watch getWatch() {
		return watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Integer getQuantityReceived() {
		return quantityReceived;
	}
	public void setQuantityReceived(Integer quantityReceived) {
		this.quantityReceived = quantityReceived;
	}
	public String getReceivedAt() {
		return receivedAt;
	}
	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	} 
    
}
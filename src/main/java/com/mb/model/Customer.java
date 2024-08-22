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
	@Table(name = "Customers")
	public class Customer {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int customerId;
	 
		//@Column( length = 100)
		private String firstName;
	 
		//@Column( length = 100)
		private String lastName;
	 
		@Column(nullable = false,  unique = true)
		private String email;
	 
		@Column(length = 20)
		private String phone;
	 
		@Column(length = 255)
		private String address;
	 
		@Column(length = 100)
		private String city;
	 
		@Column(length = 100)
		private String state;
	 
		@Column(length = 20)
		private String zipCode;
	 
		@Column(length = 100)
		private String country;
	 
		@Column(nullable = false, unique = true)
		private String username;
	 
		@Column(nullable = false)
		private String passwordHash;
		
		private String role = "user";
		
		@ManyToOne
		@JoinColumn(name = "feedbackId") // Foreign key column
		private Feedback feedback;

		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Customer(int customerId, String firstName, String lastName, String email, String phone, String address,
				String city, String state, String zipCode, String country, String username, String passwordHash,
				String role, Feedback feedback) {
			super();
			this.customerId = customerId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phone = phone;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
			this.country = country;
			this.username = username;
			this.passwordHash = passwordHash;
			this.role = role;
			this.feedback = feedback;
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPasswordHash() {
			return passwordHash;
		}

		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Feedback getFeedback() {
			return feedback;
		}

		public void setFeedback(Feedback feedback) {
			this.feedback = feedback;
		}
		
	 
	 
		
	}



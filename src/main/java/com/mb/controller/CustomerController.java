package com.mb.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.service.CustomerService;
import com.mb.model.Customer;
@CrossOrigin("*")
@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
    private CustomerService customerService;
 
    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
 
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }
 
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }
 
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setCustomerId(id);
        customerService.updateCustomer(id, customer);
        return customer;
    }
 
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomerById(id);
    }

}

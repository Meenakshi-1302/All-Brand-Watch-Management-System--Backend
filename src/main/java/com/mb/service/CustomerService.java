package com.mb.service;

import java.util.List;

import com.mb.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    List<Customer> getAllCustomers();
    void deleteCustomerById(int customerId);
    Customer updateCustomer(int customerId, Customer customer);

}

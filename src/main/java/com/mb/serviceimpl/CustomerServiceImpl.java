package com.mb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.model.Customer;
import com.mb.repo.CustomerRepository;
import com.mb.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
 
    @Autowired
    private CustomerRepository customerRepository;
 
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
 
    @Override
    public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId);
    }
 
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
 
    @Override
    public void deleteCustomerById(int customerId) {
        customerRepository.delete(customerId);
    }
 
    @Override
    public Customer updateCustomer(int customerId, Customer customer) {
        if (customerRepository.findById(customerId) != null) {
            customer.setCustomerId(customerId);
            return customerRepository.update(customer);
        }
        return null;
    }
}

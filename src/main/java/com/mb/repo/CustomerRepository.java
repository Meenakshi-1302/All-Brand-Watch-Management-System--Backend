package com.mb.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mb.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
 
    public Customer findById(int id) {
        return entityManager.find(Customer.class, id);
    }
 
    public List<Customer> findAll() {
        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }
 
    public Customer save(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }
 
    public Customer update(Customer customer) {
        return entityManager.merge(customer);
    }
 
    public void delete(int id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
 
	
}

package com.mb.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mb.model.Customer;
import com.mb.repo.CustomerRepository;

class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerserviceimpl;

    @Mock
    private CustomerRepository customerrepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCustomer() {
        Customer customer = new Customer();
        when(customerrepository.save(any(Customer.class))).thenReturn(customer);

        Customer result = customerserviceimpl.saveCustomer(customer);

        assertNotNull(result);
        assertEquals(customer, result);
        verify(customerrepository, times(1)).save(any(Customer.class));
    }

    @Test
    void testGetCustomerById() {
        Customer customer = new Customer();
        int customerId = 1;
        when(customerrepository.findById(customerId)).thenReturn(customer);

        Customer result = customerserviceimpl.getCustomerById(customerId);

        assertNotNull(result);
        assertEquals(customer, result);
        verify(customerrepository, times(1)).findById(customerId);
    }

    @Test
    void testGetAllCustomers() {
        Customer customer = new Customer();
        when(customerrepository.findAll()).thenReturn(Collections.singletonList(customer));

        List<Customer> result = customerserviceimpl.getAllCustomers();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(customer, result.get(0));
        verify(customerrepository, times(1)).findAll();
    }

//    @Test
//    void testDeleteCustomerById() {
//        int customerId = 1;
//        doNothing().when(customerrepository).delete(customerId);
//
//        customerserviceimpl.deleteCustomerById(customerId);
//
//        verify(customerrepository, times(1)).delete(customerId);
//    }
//
//    @Test
//    void testUpdateCustomer_Success() {
//        Customer existingCustomer = new Customer();
//        existingCustomer.setCustomerId(1);
//        Customer updatedCustomer = new Customer();
//        updatedCustomer.setCustomerId(1);
//        
//        when(customerrepository.findById(1)).thenReturn(existingCustomer);
//        when(customerrepository.update(updatedCustomer)).thenReturn(updatedCustomer);
//
//        Customer result = customerserviceimpl.updateCustomer(1, updatedCustomer);
//
//        assertNotNull(result);
//        assertEquals(updatedCustomer, result);
//        verify(customerrepository, times(1)).findById(1);
//        verify(customerrepository, times(1)).update(updatedCustomer);
//    }
//
//    @Test
//    void testUpdateCustomer_Failure() {
//        Customer updatedCustomer = new Customer();
//        
//        when(customerrepository.findById(1)).thenReturn(null);
//
//        Customer result = customerserviceimpl.updateCustomer(1, updatedCustomer);
//
//        assertNull(result);
//        verify(customerrepository, times(1)).findById(1);
//        verify(customerrepository, times(0)).update(any(Customer.class));
//    }
}

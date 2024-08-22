package com.mb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.model.AdministrativeUser;
import com.mb.model.Customer;
import com.mb.model.Login;
import com.mb.service.AdministrativeUserService;
import com.mb.service.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
    private AdministrativeUserService administrativeUserService;
 
    @Autowired
    private CustomerService customerService;
 
    @PostMapping
    public Object login(@RequestBody Login login) {
    	
        String email = login.getEmail();
        String password = login.getPassword();
 
        // Authenticate AdministrativeUser
        List<AdministrativeUser> admins = administrativeUserService.getAllAdministrativeUsers();
        for (AdministrativeUser admin : admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                // Successful login for administrative user
                return admin; // Return the logged-in administrative user details
            }
        }
 
        // Authenticate Customer
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPasswordHash().equals(password)) {
                // Successful login for customer
                return customer; // Return the logged-in customer details
            }
        }
 
        // Authentication failed
        return "Login failed: Invalid email or password";
    }
	
	

}

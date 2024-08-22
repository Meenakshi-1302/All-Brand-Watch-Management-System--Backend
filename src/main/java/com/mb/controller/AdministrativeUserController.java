package com.mb.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.model.AdministrativeUser;
import com.mb.service.AdministrativeUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin-users")
public class AdministrativeUserController {
 
    @Autowired
    private AdministrativeUserService administrativeUserService;
 
    @PostMapping
    public AdministrativeUser createAdministrativeUser(@RequestBody AdministrativeUser administrativeUser) {
        return administrativeUserService.saveAdministrativeUser(administrativeUser);
    }
 
    @PutMapping("/{id}")
    public AdministrativeUser updateAdministrativeUser(@PathVariable("id") int id, @RequestBody AdministrativeUser administrativeUser) {
        if (administrativeUser.getAdminUserId() != id) {
            throw new IllegalArgumentException("AdministrativeUser ID mismatch");
        }
        return administrativeUserService.updateAdministrativeUser(administrativeUser);
    }
 
    @DeleteMapping("/{id}")
    public void deleteAdministrativeUser(@PathVariable("id") int id) {
        administrativeUserService.deleteAdministrativeUser(id);
    }
 
    @GetMapping("/{id}")
    public AdministrativeUser getAdministrativeUserById(@PathVariable("id") int id) {
    	return administrativeUserService.getAdministrativeUserById(id);
    }
 
    @GetMapping("/all")
    public List<AdministrativeUser> getAllAdministrativeUsers() {
        return administrativeUserService.getAllAdministrativeUsers();
    }
    
  
    
    @PatchMapping("/lastlogin/{id}")
    public AdministrativeUser updateLastLoginDate(@PathVariable("id") int id) {
        AdministrativeUser user = administrativeUserService.getAdministrativeUserById(id);
        if (user != null) {
            user.setLastLoginDate(new Date());
            return administrativeUserService.updateAdministrativeUser(user);
        }
        return null;
    }
}

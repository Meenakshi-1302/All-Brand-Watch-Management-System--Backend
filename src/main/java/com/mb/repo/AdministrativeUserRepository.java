package com.mb.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mb.model.AdministrativeUser;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdministrativeUserRepository {
 
	 @Autowired
	    EntityManager entityManager;
	    
	    
 
	    public AdministrativeUser findById(int id) {
	        return entityManager.find(AdministrativeUser.class, id);
	    }
 
	    public List<AdministrativeUser> findAll() {
	        return entityManager.createQuery("SELECT c FROM AdministrativeUser c", AdministrativeUser.class).getResultList();
	    }
 
	    public AdministrativeUser save(AdministrativeUser administrativeUser) {
	        entityManager.persist(administrativeUser);
	        return administrativeUser;
	    }
 
	    public AdministrativeUser update(AdministrativeUser administrativeUser) {
	        entityManager.merge(administrativeUser);
	        return administrativeUser;
	    }
 
	    public void delete(int id) {
	    	AdministrativeUser administrativeUser = findById(id);
	        if (administrativeUser != null) {
	            entityManager.remove(administrativeUser);
	        }
	    }
}

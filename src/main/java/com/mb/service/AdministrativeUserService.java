package com.mb.service;

import java.util.List;

import com.mb.model.AdministrativeUser;

public interface AdministrativeUserService {

	  AdministrativeUser saveAdministrativeUser(AdministrativeUser user);
	    AdministrativeUser getAdministrativeUserById(int userId);
	    List<AdministrativeUser> getAllAdministrativeUsers();
	    void deleteAdministrativeUser(int userId);
	    AdministrativeUser updateAdministrativeUser(AdministrativeUser user);
}

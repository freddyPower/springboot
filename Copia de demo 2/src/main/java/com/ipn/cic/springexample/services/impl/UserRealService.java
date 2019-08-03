package com.ipn.cic.springexample.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ipn.cic.springexample.exception.CICException;
import com.ipn.cic.springexample.model.RolModel;
import com.ipn.cic.springexample.model.UserModel;
import com.ipn.cic.springexample.repositories.UserRepository;
import com.ipn.cic.springexample.services.IUserService;

@Service 
@Qualifier("REAL")
public class UserRealService implements IUserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserModel save(UserModel user) {
		repository.save(user);
		return user;
	}

	@Override
	public UserModel update(UserModel user) {
		user = repository.save(user);
		return user;
	}

	@Override
	public List<UserModel> getAll() {
		
		return repository.findAll();
	}

	@Override
	public boolean delete(UserModel user) {
		repository.delete(user);
		return false;
	}

	@Override
	public UserModel findById(String id) throws CICException {
		
		Optional<UserModel> user = repository.findById(id); 
		
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new CICException("No se encontro el usuario");
		}
		
		
	}

	@Override
	public UserModel findByName(String name) {
		
		UserModel user = repository.findByName(name); 
		
		return user;
	}

	@Override
	public UserModel findByNameContains(String name) {
		UserModel user = repository.findByNameContains(name); 
		return user;
	}

	@Override
	public List<UserModel> findByRol(RolModel rol) {
		
		return repository.findByRol(rol);
	}

	@Override
	public List<UserModel> findByRol_Name(RolModel rol) {
		
		return repository.findByRol_Name(rol);
	}

}

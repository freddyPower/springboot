package com.ipn.cic.springexample.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ipn.cic.springexample.model.RolModel;
import com.ipn.cic.springexample.model.UserModel;
import com.ipn.cic.springexample.repositories.UserDummyRepository;
import com.ipn.cic.springexample.services.IUserService;


@Service 
@Qualifier("DUMMY")
public class UserDummyServiceImpl implements IUserService{
	
	@Autowired
	private UserDummyRepository userRepository;

	@Override
	public UserModel save(UserModel user) {
		System.out.println("saving: .." + user.toString());
		UserModel u = userRepository.save(user);
		return u;
	}

	@Override
	public UserModel update(UserModel user) {
		UserModel u = userRepository.update(user);
		return u;
	}

	@Override
	public List<UserModel> getAll() {
		return userRepository.getAll();
	}

	@Override
	public boolean delete(UserModel user) {
		return userRepository.delete(user);
	}

	@Override
	public UserModel findById(int id) {
		
		
		UserModel u = userRepository.findById(id);
		//TODO Hacer manejo de excepciones
		return u;
	}

	@Override
	public UserModel findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel findByNameContains(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> findByRol(RolModel rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> findByRol_Name(RolModel rol) {
		// TODO Auto-generated method stub
		return null;
	}

}

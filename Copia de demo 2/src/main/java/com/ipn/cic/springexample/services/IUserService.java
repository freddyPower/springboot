package com.ipn.cic.springexample.services;

import java.util.List;

import com.ipn.cic.springexample.model.RolModel;
import com.ipn.cic.springexample.model.UserModel;


public interface IUserService {
	
	public UserModel save(UserModel  user);
	
	public UserModel update(UserModel user);
	
	public List<UserModel> getAll();
	
	public boolean  delete(UserModel user);
	
	public UserModel findById( String id);
	
	public UserModel findByName( String name);
	
	public UserModel findByNameContains( String name);
	
	public List<UserModel> findByRol(RolModel rol);
	
	public List<UserModel> findByRol_Name(RolModel rol);

}

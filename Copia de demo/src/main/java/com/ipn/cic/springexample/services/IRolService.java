package com.ipn.cic.springexample.services;

import java.util.List;

import com.ipn.cic.springexample.model.RolModel;

public interface IRolService {
	
	RolModel save(RolModel rol);
	
	RolModel update(RolModel rol);
	
	boolean delete(RolModel rol);
	
	List<RolModel> getAll();
	
	RolModel findById(int id);

}

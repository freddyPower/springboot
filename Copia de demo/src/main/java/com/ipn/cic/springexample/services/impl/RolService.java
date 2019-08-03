package com.ipn.cic.springexample.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ipn.cic.springexample.exception.CICException;
import com.ipn.cic.springexample.model.RolModel;
import com.ipn.cic.springexample.model.UserModel;
import com.ipn.cic.springexample.repositories.RolRepository;
import com.ipn.cic.springexample.services.IRolService;



@Service 
@Qualifier("REAL")
public class RolService implements IRolService{
	
	@Autowired
	public RolRepository repository;

	@Override
	public RolModel save(RolModel rol) {
		return repository.save(rol);
	}

	@Override
	public RolModel update(RolModel rol) {
		return repository.save(rol);
	}

	@Override
	public boolean delete(RolModel rol) {
		repository.delete(rol);
		return true;
	}

	@Override
	public List<RolModel> getAll() {
		return repository.findAll();
	}


	@Override
	public RolModel findById(int id)  throws CICException {
		
		Optional<RolModel> rol = repository.findById(id);
		
		if(rol.isPresent()) {
			return rol.get();
		}else {
			throw new CICException("No se encontro el usuario");
		}
		
		
	}

}

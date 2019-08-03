package com.ipn.cic.springexample.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipn.cic.springexample.model.RolModel;
import com.ipn.cic.springexample.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer>{
	
	UserModel findByName(String name);
	
	UserModel findByNameContains(String name);
	
	List<UserModel> findByRol(RolModel rol);
	
	List<UserModel> findByRol_Name(RolModel rol);
	
	
}

package com.ipn.cic.springexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipn.cic.springexample.model.RolModel;

@Repository
public interface RolRepository extends JpaRepository<RolModel,Integer>{

	
	
}

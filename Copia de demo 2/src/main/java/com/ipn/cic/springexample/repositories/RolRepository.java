package com.ipn.cic.springexample.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ipn.cic.springexample.model.RolModel;

@Repository
public interface RolRepository extends MongoRepository<RolModel,String>{

	
	
}

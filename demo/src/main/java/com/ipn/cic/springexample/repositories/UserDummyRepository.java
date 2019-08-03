package com.ipn.cic.springexample.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ipn.cic.springexample.model.UserModel;

@Repository 
public class UserDummyRepository {
	
	private int count = 0;
	private List<UserModel> list = new ArrayList<UserModel>();
	
	

	public UserDummyRepository() {
		
		list =  new ArrayList<>();
		
		list.add( new UserModel(1,"Luis" , "Sanchez" , "Angeles" , 27) );
		list.add( new UserModel(2,"Luis" , "Sanchez" , "Angeles" , 27) );
		list.add( new UserModel(3,"Luis" , "Sanchez" , "Angeles" , 27) );
		list.add( new UserModel(4,"Luis" , "Sanchez" , "Angeles" , 27) );
		list.add( new UserModel(5,"Luis" , "Sanchez" , "Angeles" , 27) );
		
		count = 5 ;
		
	}

	public UserModel save(UserModel  user) {
		user.setId(++count);
		this.list.add(user);
		return user;
	}
	
	public UserModel update(UserModel user) {
		user.setName( String.format("%s modificado", user.getName()) );
		
		UserModel originalUser = this.findById(user.getId());
		
		originalUser.setAge(user.getAge());
		originalUser.setName(user.getName());
		originalUser.setName(user.getLastName());
		originalUser.setSecondLastName(user.getSecondLastName());
		
		
		return originalUser;
	}
	
	public List<UserModel> getAll(){
		
		return this.list;
		
	}
	
	public boolean  delete(UserModel user) {
		if(list.contains(user)) {
			return list.remove(user);
		}else {
			return false;
		}
	}
	
	public UserModel findById( int id) {
		for(  UserModel  user : this.list) {
			if( user.getId() == id ) {
				return user;
			}
		}
		return null;
	}
	
	
}

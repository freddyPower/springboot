package com.ipn.cic.springexample.model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rol")
public class RolModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id	
	private String id;
		
	private String name;
	
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public RolModel(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public RolModel() {
		super();
	}
	@Override
	public String toString() {
		return String.format("RolModel [id=%s, name=%s, description=%s]", id, name, description);
	}
	
	
	
}

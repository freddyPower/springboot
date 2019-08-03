package com.ipn.cic.springexample.model;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="userss")
public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	private String id;
	
	@NotEmpty
	@Size(min = 3 , max = 25)
	
	private String name;
	
	@NotEmpty
	@Size(min=4 , max = 55)
	
	private String lastName;	
	
	private String secondLastName;
	
	@Min(value=18 , message="No puedes tener menos de 18 anios")		
	private int age;
		
	
	private String direccion;
	
	
	private RolModel rol;
	
	public UserModel() {
		super();
		this.name="Freddy";
	}
	
	public UserModel(String id, String name, String lastname, String second_last_name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastname;
		this.secondLastName = second_last_name;
		this.age = age;
	}
	
	public UserModel(String name, String lastname, String second_last_name, int age) {
		super();		
		this.name = name;
		this.lastName = lastname;
		this.secondLastName = second_last_name;
		this.age = age;
	}
	
	
	public UserModel(String name, String lastname, String second_last_name) {
		super();		
		this.name = name;
		this.lastName = lastname;
		this.secondLastName = second_last_name;
		
	}
	
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
	
	
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
		

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

	public RolModel getRol() {
		return rol;
	}

	public void setRol(RolModel rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return String.format("UserModel [id=%s, name=%s, lastName=%s, secondLastName=%s, age=%s]", id, name, lastName,
				secondLastName, age);
	}

	
	
	
}

package com.lyons.sports.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	
	@JsonProperty
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	@JsonProperty
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@JsonProperty
	public String getLastName() {
		return lastName;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@JsonProperty
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

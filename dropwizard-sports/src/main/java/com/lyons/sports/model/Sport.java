package com.lyons.sports.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sport {
	
	private int id;
	private String name;
	
	public Sport() {
		super();
	}

	public Sport(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@JsonProperty
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + "]";
	}
}

package com.lyons.sports.model;

import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sport {
	
	@ObjectId
	@JsonProperty("_id")
	private int id;
	@JsonProperty
	private String name;
	@JsonProperty
	private String acronym;
	
	public Sport() {
		super();
	}

	public Sport(int id, String name, String acronym) {
		super();
		this.id = id;
		this.name = name;
		this.acronym = acronym;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + "]";
	}
}

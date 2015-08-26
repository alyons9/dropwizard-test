package com.lyons.sports.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
	
	private int id;
	private String name;
	private String iconPath;
	private String mascot;
	
	public Team(int id, String name, String iconPath, String mascot) {
		super();
		this.id = id;
		this.name = name;
		this.iconPath = iconPath;
		this.mascot = mascot;
	}
	
	public Team() {
		super();
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

	@JsonProperty
	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	@JsonProperty
	public String getMascot() {
		return mascot;
	}

	public void setMascot(String mascot) {
		this.mascot = mascot;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", iconPath=" + iconPath + ", mascot=" + mascot + "]";
	}

}

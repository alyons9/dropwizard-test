package com.lyons.sports.configuration;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class SportsAppConfiguration extends Configuration {

	@NotNull
	private String template;
	
	@NotNull
	private String defaultName = "Sports App";
	
	@JsonProperty
    @NotEmpty
    private String mongohost = "localhost";
 
    @JsonProperty
    @Min(1)
    @Max(65535)
    private int mongoport = 27000;
 
    @JsonProperty
    @NotEmpty
    private String mongodb = "LyonsData";

	@JsonProperty
	public String getTemplate() {
		return template;
	}
	
	@JsonProperty
	public void setTemplate(String template) {
		this.template = template;
	}

	@JsonProperty
	public String getDefaultName() {
		return defaultName;
	}

	@JsonProperty
	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	public String getMongohost() {
		return mongohost;
	}

	public void setMongohost(String mongohost) {
		this.mongohost = mongohost;
	}

	public int getMongoport() {
		return mongoport;
	}

	public void setMongoport(int mongoport) {
		this.mongoport = mongoport;
	}

	public String getMongodb() {
		return mongodb;
	}

	public void setMongodb(String mongodb) {
		this.mongodb = mongodb;
	}
	
}
 
package com.lyons.sports.configuration;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class SportsAppConfiguration extends Configuration {

	@NotNull
	private String template;
	
	@NotNull
	private String defaultName = "Sports App";

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
	
	
	
	
}
 
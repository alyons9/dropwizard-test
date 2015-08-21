package com.lyons.sports.health;

import com.codahale.metrics.health.HealthCheck;

public class SportsHealth extends HealthCheck {

	private final String template;
	
	public SportsHealth(String template) {
		super();
		this.template = template;
	}

	@Override
	protected Result check() throws Exception {
		
        return Result.healthy();
	}
	
}

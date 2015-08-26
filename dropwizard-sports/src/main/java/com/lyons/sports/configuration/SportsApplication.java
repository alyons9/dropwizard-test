package com.lyons.sports.configuration;

import com.lyons.sports.health.SportsHealth;
import com.lyons.sports.resource.SportsResource;
import com.lyons.sports.resource.TeamResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SportsApplication extends Application<SportsAppConfiguration> {

	public static void main(String args[]) throws Exception{
		new SportsApplication().run(args);
	}
	
	@Override
	public void run(SportsAppConfiguration configuration, Environment env) throws Exception {
		// TODO Auto-generated method stub
		final SportsResource sportsResource = 
				new SportsResource(
						configuration.getTemplate(), 
						configuration.getDefaultName()
						);
		final TeamResource teamResource = new TeamResource();
		final SportsHealth healthCheck =
		        new SportsHealth(configuration.getTemplate());
		env.healthChecks().register("template", healthCheck);
		env.jersey().register(sportsResource);
		env.jersey().register(teamResource);
	}
	
	/*
	 * (non-Javadoc)
	 * Used to initialize bundles, source providers and etc before app runs
	 * @see io.dropwizard.Application#initialize(io.dropwizard.setup.Bootstrap)
	 */
	@Override
	public void initialize(Bootstrap<SportsAppConfiguration> bootstrap){
		
	}
	
	@Override
	public String getName(){
		return "SportsApplication";
	}

}

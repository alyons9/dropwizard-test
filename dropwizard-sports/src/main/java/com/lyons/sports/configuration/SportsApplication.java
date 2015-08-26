package com.lyons.sports.configuration;

import com.lyons.sports.health.SportsHealth;
import com.lyons.sports.resource.SportsResource;
import com.lyons.sports.resource.TeamResource;
import com.lyons.sports.resource.UserResource;

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
		addHealthChecks(configuration, env);
		addResources(configuration, env);
	}
	
	/*
	 * Add all health checks here
	 */
	private void addHealthChecks(SportsAppConfiguration configuration, Environment env){
		final SportsHealth healthCheck =
		        new SportsHealth(configuration.getTemplate());
		env.healthChecks().register("template", healthCheck);
	}
	
	/*
	 * Add all resources here.
	 */
	private void addResources(SportsAppConfiguration configuration, Environment env){
		final SportsResource sportsResource = 
				new SportsResource(
						configuration.getTemplate(), 
						configuration.getDefaultName()
						);
		final TeamResource teamResource = new TeamResource();
		final UserResource userResource = new UserResource();
		
		env.jersey().register(sportsResource);
		env.jersey().register(teamResource);
		env.jersey().register(userResource);
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

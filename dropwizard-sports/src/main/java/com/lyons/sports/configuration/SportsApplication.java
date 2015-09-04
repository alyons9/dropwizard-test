package com.lyons.sports.configuration;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.mongojack.JacksonDBCollection;

import com.lyons.sports.health.MongoHealthCheck;
import com.lyons.sports.health.SportsHealth;
import com.lyons.sports.model.Article;
import com.lyons.sports.model.Sport;
import com.lyons.sports.resource.SportsResource;
import com.lyons.sports.resource.TeamResource;
import com.lyons.sports.resource.UserResource;
import com.mongodb.DB;
import com.mongodb.Mongo;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SportsApplication extends Application<SportsAppConfiguration> {

	public static void main(String args[]) throws Exception{
		new SportsApplication().run(args);
	}
	
	@Override
	public void run(SportsAppConfiguration configuration, Environment env) throws Exception {
		
		//Mongo
		Mongo mongo = new Mongo(configuration.getMongohost(), configuration.getMongoport());
        MongoManaged mongoManaged = new MongoManaged(mongo);
        env.lifecycle().manage(mongoManaged);
		
		addHealthChecks(configuration, env, mongo);
		addResources(configuration, env, mongo);
		
		FilterRegistration.Dynamic filter = env.servlets().addFilter("CORS", CrossOriginFilter.class);
		filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
	}
	
	/*
	 * Add all health checks here
	 */
	private void addHealthChecks(SportsAppConfiguration configuration, Environment env,  Mongo mongo){
		final SportsHealth healthCheck =
		        new SportsHealth(configuration.getTemplate());
		
		env.healthChecks().register("template", healthCheck);
		env.healthChecks().register("mongoHealth", new MongoHealthCheck(mongo));
	}
	
	/*
	 * Add all resources here.
	 */
	private void addResources(SportsAppConfiguration configuration, Environment env, Mongo mongo){
		
		DB db = mongo.getDB(configuration.getMongodb());
        JacksonDBCollection<Sport, String> sports = 
        		JacksonDBCollection.wrap(db.getCollection("sports"), Sport.class, String.class);
        JacksonDBCollection<Article, String> articles = 
        		JacksonDBCollection.wrap(db.getCollection("articles"), Article.class, String.class);
		final SportsResource sportsResource = 
				new SportsResource(
						configuration.getTemplate(), 
						configuration.getDefaultName(),
						sports,
						articles
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

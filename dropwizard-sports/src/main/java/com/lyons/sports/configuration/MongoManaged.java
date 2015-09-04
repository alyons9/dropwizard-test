package com.lyons.sports.configuration;

import com.mongodb.Mongo;

import io.dropwizard.lifecycle.Managed;
 
public class MongoManaged implements Managed {
 
    private Mongo mongo;
 
    public MongoManaged(Mongo mongo) {
        this.mongo = mongo;
    }

	public void start() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void stop() throws Exception {
		// TODO Auto-generated method stub
		mongo.close();
	}
 
}
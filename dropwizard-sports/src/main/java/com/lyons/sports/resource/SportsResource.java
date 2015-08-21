package com.lyons.sports.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lyons.sports.model.Sport;

@Path("/sports")
@Produces(MediaType.APPLICATION_JSON)
public class SportsResource {
	
	private String template;
	private String defaultName;
	public SportsResource(String template, String defaultName) {
		super();
		this.template = template;
		this.defaultName = defaultName;
	}
	
	@GET
	public List<Sport> getSports(){
		//Adding filler methods for test
		List<Sport> sports = new ArrayList<Sport>();
		for(int i = 0; i<10;i++){
			sports.add(new Sport(i, "sport" + i));
		}
		
		return sports;
	}
	
	@GET
	@Path("/{id}")
	public Sport getSport(@PathParam("id") int id){
		//Adding filler methods for test
		return new Sport(id, "sport" + id);
	}

}

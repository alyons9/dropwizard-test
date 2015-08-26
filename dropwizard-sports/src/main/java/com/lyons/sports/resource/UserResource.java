package com.lyons.sports.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lyons.sports.model.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	//Creating a temporary stor until I create a database.
	private List<User> users = new ArrayList<User>();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(User user){
		users.add(user);
	}
	
	@GET
	@Path("/{id}")
	public User getUser(@PathParam("id") int id){
		
		return users.get(id);
	}

}

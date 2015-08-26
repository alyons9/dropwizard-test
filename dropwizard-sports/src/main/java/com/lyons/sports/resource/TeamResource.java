package com.lyons.sports.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lyons.sports.model.Team;

@Path("/team")
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {
	
	@GET
	public List<Team> getTeams(){
		List<Team> teams = new ArrayList<Team>();
		for(int i = 0; i < 10; i++){
			teams.add(new Team(i, "team" + i, "",""));
		}
		
		return teams;
	}

}

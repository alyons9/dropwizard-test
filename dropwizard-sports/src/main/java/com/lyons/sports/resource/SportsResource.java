package com.lyons.sports.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mongojack.DBCursor;
import org.mongojack.DBSort;
import org.mongojack.JacksonDBCollection;

import com.lyons.sports.model.Article;
import com.lyons.sports.model.Sport;

@Path("/sports")
@Produces(MediaType.APPLICATION_JSON)
public class SportsResource {
	
	private String template;
	private String defaultName;
	private JacksonDBCollection<Sport, String> sportsCollection;
	private JacksonDBCollection<Article, String> sportsArticleCollection;
	
	public SportsResource(String template, 
			String defaultName,
			JacksonDBCollection<Sport, String> sportsCollection,
			JacksonDBCollection<Article, String> sportsArticleCollection) {
		super();
		this.template = template;
		this.defaultName = defaultName;
		this.sportsCollection = sportsCollection;
		this.sportsArticleCollection = sportsArticleCollection;
	}
	
	private Map<Integer,Sport> sports = new HashMap<Integer,Sport>();
//	private Map<Integer,Article> sportsArticle = new HashMap<Integer,Article>();
	
	@GET
	public List<Sport> getSports(){
		//Adding filler methods for test
		DBCursor<Sport> cursor = sportsCollection.find();
		
		return new ArrayList<Sport>(sports.values());
	}
	
	@GET
	@Path("/{id}")
	public Sport getSport(@PathParam("id") int id){
		//Adding filler methods for test
		return new Sport(id, "sport" + id, "SPT");
	}
	
	@GET
	@Path("/article")
	public List<Article> getSportsArticles(){
		

		List<Article> articles = sportsArticleCollection.find().sort(DBSort.asc("creationDate")).toArray();

		return articles;
	}
	
	@GET
	@Path("/article/{id}")
	public Article getSportsArticles(@PathParam("id")String id){
		return sportsArticleCollection.findOneById(id);
//		return sportsArticle.get(id);
	}
	
	@POST
	@Path("/article")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSportsArticle(@Valid Article article){
		if(article.getCreationDate() == null){
			article.setCreationDate(new Date());
		}
		sportsArticleCollection.insert(article);
		
		return Response.noContent().build();
	}

}

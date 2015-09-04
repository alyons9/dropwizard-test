package com.lyons.sports.model;

import java.util.Date;

import javax.persistence.Id;

import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {
	
	private String id;
	private String title;
	private String summary;
	private Date creationDate;
	private String createdBy;
	private String picturePath;
	public Article(String title, String summary, Date creationDate, String createdBy, String picturePath) {
		super();
		this.title = title;
		this.summary = summary;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.picturePath = picturePath;
	}
	public Article() {
		super();
	}
	
	@ObjectId
	@Id
	public String getId() {
		return id;
	}
	
	@ObjectId
	@Id
	public void setId(String _id) {
		this.id = _id;
	}
	@JsonProperty
	public String getTitle() {
		return title;
	}
	@JsonProperty
	public void setTitle(String title) {
		this.title = title;
	}
	@JsonProperty
	public String getSummary() {
		return summary;
	}
	@JsonProperty
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@JsonProperty
	public Date getCreationDate() {
		return creationDate;
	}
	@JsonProperty
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@JsonProperty
	public String getCreatedBy() {
		return createdBy;
	}
	@JsonProperty
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@JsonProperty
	public String getPicturePath() {
		return picturePath;
	}
	@JsonProperty
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	@Override
	public String toString() {
		return "Article [title=" + title + ", summary=" + summary + ", creationDate=" + creationDate + ", createdBy="
				+ createdBy + ", picturePath=" + picturePath + "]";
	}

}

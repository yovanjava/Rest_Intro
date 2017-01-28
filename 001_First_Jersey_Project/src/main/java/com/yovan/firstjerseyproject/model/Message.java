package com.yovan.firstjerseyproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	private Long id;
	private String content;
	private String author;
	private Date createdAt;
	private Map<Long, Comment> commentsMap = new HashMap<>();
	private List<Link> linksList = new ArrayList<>();

	public Message() {
	}

	public Message(Long id, String content, String author, Date createdAt) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
		this.createdAt = createdAt;
	}

	public Message(String content, String author, Date createdAt) {
		super();
		this.content = content;
		this.author = author;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@XmlTransient
	public Map<Long, Comment> getCommentsMap() {
		return commentsMap;
	}

	public void setCommentsMap(Map<Long, Comment> commentsMap) {
		this.commentsMap = commentsMap;
	}

	 @XmlElement(name = "links")
	public List<Link> getLinksList() {
		return linksList;
	}

	public void setLinksList(List<Link> linksList) {
		this.linksList = linksList;
	}
	
	public void addLink(String url, String rel) {
		Link link = new Link(url, rel);
		linksList.add(link);
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", author=" + author + ", createdAt=" + createdAt + "]";
	}

}

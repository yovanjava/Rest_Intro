package com.yovan.firstjerseyproject.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	private Long id;
	private String content;
	private String author;
	private Date createdAt;
	private Map<Long, Comment> commentsMap = new HashMap<>();

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

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", author=" + author + ", createdAt=" + createdAt + "]";
	}

}

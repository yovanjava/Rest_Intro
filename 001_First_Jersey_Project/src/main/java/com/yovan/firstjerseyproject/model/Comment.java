package com.yovan.firstjerseyproject.model;

import java.util.Date;

public class Comment {

	private Long id;
	private String content;
	private String author;
	private Date createdAt;

	public Comment() {
	}

	public Comment(Long id, String content, String author, Date createdAt) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
		this.createdAt = createdAt;
	}

	public Comment(String content, String author, Date createdAt) {
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

}

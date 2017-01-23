package com.yovan.firstjerseyproject.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private long id;
	private String content;
	private String author;
	private Date createdAt;

	public Message() {
	}

	public Message(long id, String content, String author, Date createdAt) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

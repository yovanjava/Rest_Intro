package com.yovan.firstjerseyproject.model;

import java.util.Date;

public class Profile {

	private long id;
	private String firstName;
	private String lastName;
	private String name;
	private Date createdAt;
	private String address;

	public Profile() {
	}

	public Profile(long id, String firstName, String lastName, String name, Date createdAt, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = name;
		this.createdAt = createdAt;
		this.address = address;
	}

	public Profile(String firstName, String lastName, String name, Date createdAt, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = name;
		this.createdAt = createdAt;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

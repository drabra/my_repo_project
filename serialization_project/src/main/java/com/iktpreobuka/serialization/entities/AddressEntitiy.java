package com.iktpreobuka.serialization.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.serialization.security.Views;

public class AddressEntitiy {
	
	private Integer id;
	private String street;
	private String city;
	private String country;
	private Integer version;
	
	@JsonBackReference
	private List<UserEntity> users = new ArrayList<>();

	@JsonView(Views.Private.class)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonView(Views.Private.class)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@JsonView(Views.Private.class)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonView(Views.Private.class)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public AddressEntitiy() {
		super();
	}

}

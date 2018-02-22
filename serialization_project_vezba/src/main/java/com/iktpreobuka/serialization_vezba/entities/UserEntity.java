package com.iktpreobuka.serialization_vezba.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.serialization_vezba.security.Views;

import net.minidev.json.annotate.JsonIgnore;


public class UserEntity {
	
	private Integer id;
	private String name;
	private Date dateOfBirth;
	private String email;
	private String password;
	private Integer version;
	
	@JsonManagedReference
	private AddressEntity address;

	@JsonView(Views.Public.class)
	@JsonProperty("ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonView(Views.Public.class)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonView(Views.Admin.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM--yyyy hh:mm:ss")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@JsonView(Views.Admin.class)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@JsonView(Views.Private.class)
	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public UserEntity(Integer id, String name, Date dateOfBirth, String email, String password, Integer version,
			AddressEntity address) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.password = password;
		this.version = version;
		this.address = address;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}

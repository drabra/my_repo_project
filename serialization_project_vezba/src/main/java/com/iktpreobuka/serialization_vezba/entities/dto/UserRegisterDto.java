package com.iktpreobuka.serialization_vezba.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegisterDto {

	private String name;
	private String email;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRegisterDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public UserRegisterDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}

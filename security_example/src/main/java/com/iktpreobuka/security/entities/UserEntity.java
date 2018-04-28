package com.iktpreobuka.security.entities;

import net.minidev.json.annotate.JsonIgnore;

public class UserEntity {

	private Integer id;
	private String email;
	@JsonIgnore
	private String password;
	private String name;
	private String lastname;
	private RoleEntity role;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	public UserEntity(Integer id, String email, String password, String name, String lastname, RoleEntity role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.role = role;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}

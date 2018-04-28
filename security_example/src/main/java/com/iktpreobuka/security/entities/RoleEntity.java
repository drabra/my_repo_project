package com.iktpreobuka.security.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class RoleEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="role_id")
	private Integer id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role", fetch =  FetchType.LAZY,cascade = { CascadeType.REFRESH })
	private List<UserEntity> users = new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	public RoleEntity(Integer id, String name, List<UserEntity> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}
	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}

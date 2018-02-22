package com.iktpreobuka.probni.entities;

public class Ucenik {
	
	private Integer id;
	private String name;
	private String surname;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Ucenik(Integer id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	public Ucenik() {
		super();
		// TODO Auto-generated constructor stub
	}

}

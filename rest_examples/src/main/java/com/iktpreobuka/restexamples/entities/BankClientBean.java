package com.iktpreobuka.restexamples.entities;

import java.util.Date;

public class BankClientBean {
	
	public BankClientBean(Integer id, String name, String surname, String email) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	public BankClientBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer id;
	protected String name;
	protected String surname;
	protected String email;
	protected String birthDate;
	protected String bonitet;
	

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getBonitet() {
		return bonitet;
	}
	public void setBonitet(String bonitet) {
		this.bonitet = bonitet;
	}
	public static Date dateParsing(String birthDate2) {
		// TODO Auto-generated method stub
		return null;
	}
	public static int getYearsBetween(Date dateOfBirth, Date date) {
		// TODO Auto-generated method stub
		return 0;
	}

}






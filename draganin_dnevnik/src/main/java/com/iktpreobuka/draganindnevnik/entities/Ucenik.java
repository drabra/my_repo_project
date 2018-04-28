package com.iktpreobuka.draganindnevnik.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ucenik {
	
	@Id
	private Integer id;
	private String prezime;
	private String ime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public Ucenik() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ucenik(Integer id, String prezime, String ime) {
		super();
		this.id = id;
		this.prezime = prezime;
		this.ime = ime;
	}

}

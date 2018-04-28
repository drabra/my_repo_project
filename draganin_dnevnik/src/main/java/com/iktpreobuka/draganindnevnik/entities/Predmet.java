package com.iktpreobuka.draganindnevnik.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Predmet {
	
	@Id
	private Integer id;
	private String naziv;
	private Integer fondCasova;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Integer getFondCasova() {
		return fondCasova;
	}
	public void setFondCasova(Integer fondCasova) {
		this.fondCasova = fondCasova;
	}
	public Predmet(Integer id, String naziv, Integer fondCasova) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fondCasova = fondCasova;
	}
	public Predmet() {
		super();
		// TODO Auto-generated constructor stub
	}

}

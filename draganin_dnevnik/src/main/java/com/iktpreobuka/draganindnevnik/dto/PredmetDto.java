package com.iktpreobuka.draganindnevnik.dto;

public class PredmetDto {

	private Integer fondCasova;
	private String naziv;
	public Integer getFondCasova() {
		return fondCasova;
	}
	public void setFondCasova(Integer fondCasova) {
		this.fondCasova = fondCasova;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public PredmetDto(Integer fondCasova, String naziv) {
		super();
		this.fondCasova = fondCasova;
		this.naziv = naziv;
	}
	public PredmetDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}

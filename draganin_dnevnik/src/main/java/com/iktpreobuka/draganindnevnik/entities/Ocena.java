package com.iktpreobuka.draganindnevnik.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ocena {

	@Id
	private Integer idOcena;
	private Integer polugodiste;
	private Integer vrednost;
	private Timestamp vremeOcenjivanja;
	private boolean zakljucnaOcena;

	public Integer getIdOcena() {
		return idOcena;
	}

	public void setIdOcena(Integer idOcena) {
		this.idOcena = idOcena;
	}

	public Integer getPolugodister() {
		return polugodiste;
	}

	public void setPolugodister(Integer polugodister) {
		this.polugodiste = polugodiste;
	}

	public Integer getVrednost() {
		return vrednost;
	}

	public void setVrednost(Integer vrednost) {
		this.vrednost = vrednost;
	}

	public Timestamp getVremeOcenjivanja() {
		return vremeOcenjivanja;
	}

	public void setVremeOcenjivanja(Timestamp vremeOcenjivanja) {
		this.vremeOcenjivanja = vremeOcenjivanja;
	}

	public boolean isZakljucnaOcena() {
		return zakljucnaOcena;
	}

	public void setZakljucnaOcena(boolean zakljucnaOcena) {
		this.zakljucnaOcena = zakljucnaOcena;
	}

	public Ocena(Integer idOcena, Integer polugodister, Integer vrednost, Timestamp vremeOcenjivanja,
			boolean zakljucnaOcena) {
		super();
		this.idOcena = idOcena;
		this.polugodiste = polugodiste;
		this.vrednost = vrednost;
		this.vremeOcenjivanja = vremeOcenjivanja;
		this.zakljucnaOcena = zakljucnaOcena;
	}

	public Ocena() {
		super();
		// TODO Auto-generated constructor stub
	}

}

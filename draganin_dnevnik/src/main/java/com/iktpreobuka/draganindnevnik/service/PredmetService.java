package com.iktpreobuka.draganindnevnik.service;

import org.springframework.http.ResponseEntity;

import com.iktpreobuka.draganindnevnik.dto.PredmetDto;
import com.iktpreobuka.draganindnevnik.entities.Predmet;

public interface PredmetService {
	 ResponseEntity<Predmet> dodaj(PredmetDto predmetDto);

}

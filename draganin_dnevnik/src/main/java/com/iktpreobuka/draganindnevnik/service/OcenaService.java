package com.iktpreobuka.draganindnevnik.service;

import org.springframework.http.ResponseEntity;

import com.iktpreobuka.draganindnevnik.dto.OcenaDto;
import com.iktpreobuka.draganindnevnik.entities.Ocena;

public interface OcenaService {
	    ResponseEntity<Ocena> oceni(OcenaDto ocenaDto);
	
}

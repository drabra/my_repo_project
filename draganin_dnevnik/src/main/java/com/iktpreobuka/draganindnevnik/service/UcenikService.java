package com.iktpreobuka.draganindnevnik.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.iktpreobuka.draganindnevnik.entities.Ocena;

public interface UcenikService {
	ResponseEntity<List<Ocena>> pregledOcena (int idUcenik);


}

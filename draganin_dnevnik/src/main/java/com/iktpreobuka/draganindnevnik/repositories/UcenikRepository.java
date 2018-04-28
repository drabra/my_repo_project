package com.iktpreobuka.draganindnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.draganindnevnik.entities.Ucenik;

public interface UcenikRepository  extends CrudRepository<Ucenik, Integer> {
    

}

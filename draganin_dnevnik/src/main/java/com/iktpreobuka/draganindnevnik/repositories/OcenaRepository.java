package com.iktpreobuka.draganindnevnik.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.draganindnevnik.entities.Ocena;
import com.iktpreobuka.draganindnevnik.entities.Ucenik;

public interface OcenaRepository  extends CrudRepository<Ocena, Integer> {
    List<Ocena> findAllByUcenikOrderByVremeOcenjivanjaDesc(Ucenik ucenik);
 

}

package com.iktpreobuka.dataaccessvezba.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dataaccessvezba.entities.AddressEntity;

public interface AddressRepository extends
    CrudRepository<AddressEntity, Integer> {

}

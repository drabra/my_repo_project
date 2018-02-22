package com.iktpreobuka.dataaccessvezba.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dataaccessvezba.entities.UserEntity;

public interface UserRepository extends
   CrudRepository<UserEntity, Integer>{
	
	

}

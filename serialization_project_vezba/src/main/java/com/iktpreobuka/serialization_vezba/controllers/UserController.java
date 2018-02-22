package com.iktpreobuka.serialization_vezba.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.serialization_vezba.controllers.util.RESTError;
import com.iktpreobuka.serialization_vezba.entities.AddressEntity;
import com.iktpreobuka.serialization_vezba.entities.UserEntity;
import com.iktpreobuka.serialization_vezba.entities.dto.UserRegisterDto;
import com.iktpreobuka.serialization_vezba.security.Views;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	public List<UserEntity> getDummyDB() {
		List<UserEntity> list = new ArrayList<>();
		
		AddressEntity addr = new AddressEntity();
		addr.setId(1);
		addr.setStreet("Glavna ulica 1");
		addr.setCity("Novi Sad");
		addr.setCountry("Srbija");
		
		UserEntity ue = new UserEntity();
		ue.setId(1);
		ue.setDateOfBirth(new Date());
		ue.setEmail("user@example.com");
		ue.setName("Dragana");
		ue.setPassword("password1234");
		ue.setVersion(0);
		ue.setAddress(addr);
		
		UserEntity ue1 = new UserEntity();
		ue1.setId(2);
		ue1.setDateOfBirth(new Date());
		ue1.setEmail("user2@gmail.com");
		ue1.setName("Jelena");
		ue1.setPassword("passxxx");
		
		addr.getUsers().add(ue);
		addr.getUsers().add(ue1);
		
		list.add(ue);
		list.add(ue1);
		
		return list;
	}
	@RequestMapping(method = RequestMethod.GET, value="/public")
	@JsonView(Views.Public.class)
	public List<UserEntity> getAllUsers() {
		return getDummyDB();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/private")
	@JsonView(Views.Private.class)
	public List<UserEntity> getAllUsersForPrivate() {
		return getDummyDB();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/admin")
	@JsonView(Views.Admin.class)
	public List<UserEntity> getAllUsersForAdmin() {
		return getDummyDB();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{userId}" )
	public ResponseEntity<?> getUserById(@PathVariable Integer userId) {
		// dodji do baze podataka
		List<UserEntity> users = getDummyDB();
		//pronadji korisnika
		UserEntity result = null;
		for (UserEntity userEntity : users) {
			if(userEntity.getId().equals(userId)) {
				result = userEntity;
				return new ResponseEntity<UserEntity>(result, HttpStatus.OK);
			
			}
		}
//vrati korisnika
//ako korisnika nema vrati null
		return new ResponseEntity<RESTError>(new RESTError(1,"zeznuo sam"), HttpStatus.NOT_FOUND);
	}
	@RequestMapping(method = RequestMethod.POST, value ="/register")
	public ResponseEntity<?> createUser (@RequestBody UserRegisterDto userDTO){
		// pretvoriti dto u user entitiy
		UserEntity uEnt = new UserEntity();
		uEnt.setName(userDTO.getName());
		uEnt.setEmail(userDTO.getEmail());
		//TODO snmiti usere u bazu podataka
		// vratiti rezultat koji pokazuje spesnost operacije
				return new ResponseEntity<>(uEnt, HttpStatus.OK);
	}
	
	

}

package com.iktpreobuka.dataaccessvezba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccessvezba.entities.AddressEntity;
import com.iktpreobuka.dataaccessvezba.entities.UserEntity;
import com.iktpreobuka.dataaccessvezba.repositories.AddressRepository;
import com.iktpreobuka.dataaccessvezba.repositories.UserRepository;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository; 
    
@RequestMapping(method = RequestMethod.POST)
public UserEntity addNewUser(@RequestParam String name, @RequestParam String email) {
	UserEntity user = new UserEntity();
	user.setName(name);
	user.setEmail(email);
	userRepository.save(user);
	return user;
}

@RequestMapping(method = RequestMethod.GET)
public Iterable<UserEntity> getAllUsers() {
	return userRepository.findAll();
}



@RequestMapping(method = RequestMethod.PUT, value = "/{id}/address")
public UserEntity addAddressToUser(@PathVariable Integer id, @RequestParam Integer address) {
	UserEntity user = userRepository.findOne(id);
	AddressEntity adr = addressRepository.findOne(address);
	user.setAddress(adr);
	userRepository.save(user); //automatski ce biti sacuvana i adresa
	return user;
}
}

package com.iktpreobuka.dataaccessvezba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccessvezba.entities.AddressEntity;
import com.iktpreobuka.dataaccessvezba.repositories.AddressRepository;
import com.iktpreobuka.dataaccessvezba.services.AddressDao;

@RestController
@RequestMapping(path = "/api/v1/addresses")
public class AddressController {
	@Autowired
	private AddressRepository adressRepository;

	@RequestMapping(method = RequestMethod.POST)
	public AddressEntity addNewAdress(@RequestParam String street, @RequestParam String city,
			@RequestParam String country) {
		AddressEntity address = new AddressEntity();
		address.setStreet(street);
		address.setCity(city);
		address.setCountry(country);
		adressRepository.save(address);
		return address;

	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<AddressEntity> getAllAddress() {
		return adressRepository.findAll();
	}

	@Autowired
	private AddressDao addressDao;

	@RequestMapping(method = RequestMethod.GET, value = "/user/{name}")
	public List<AddressEntity> addAddressToUser(@PathVariable String name) {
		return addressDao.findAdressesByUserName(name);
	}

}

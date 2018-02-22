package com.iktpreobuka.restexamplesvezb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.restexamplesvezb.entities.BankClientBean;

@RestController
@RequestMapping("/bankclients")
public class BankClientRestController {

	@RequestMapping(method = RequestMethod.GET)
	public List<BankClientBean> getAll() {
		List<BankClientBean> clients = new ArrayList<BankClientBean>();
		clients.add(new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs"));
		clients.add(new BankClientBean(2, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs"));
		return clients;
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET, value = "/{clientId}") public
	 * BankClientBean getbyID(@PathVariable String clientId) {
	 * if(clientId.equals("1")) return new BankClientBean(1, "Milan", "Celikovic",
	 * "milancel@uns.ac.rs"); else return new BankClientBean(); }
	 */
	protected List<BankClientBean> getDB() {
		List<BankClientBean> clients = new ArrayList<BankClientBean>();
		clients.add(new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs"));
		clients.add(new BankClientBean(2, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs"));
		clients.add(new BankClientBean(3, "Dragana", "Bradic", "dragana.bradic@gmail.com"));
		return clients;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{clientId}")
	public BankClientBean getById(@PathVariable String clientId) {
		for (BankClientBean bcb : getDB())
			if (bcb.getId().equals(Integer.parseInt(clientId)))
				return bcb;
		return new BankClientBean();

	}

	@RequestMapping(method = RequestMethod.POST)
	public String add(@RequestBody BankClientBean client) {
		System.out.println(client.getName().concat(" ").concat(client.getSurname()));
		return "New client added";

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{clientId}")
	public BankClientBean modify(@PathVariable String clientId, @RequestBody BankClientBean client) {

		BankClientBean bcb = new BankClientBean(1, "Milan", "Celikovic", "milancel@uns.ac.rs");
		if (clientId.equals("1")) {
			bcb.setName(client.getName());
			return bcb;
		} else
			return null;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{clientId}")
	public BankClientBean delete(@PathVariable String clientId) {
		for (BankClientBean bcb : getDB())
			if (bcb.getId().equals(Integer.parseInt(clientId))) {
				getDB().remove(bcb);
				return bcb;
			}
		return new BankClientBean();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/client")
	public BankClientBean getByNameSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
		if (name.equals("Milan") && surname.equals("Celikovic"))

			return new BankClientBean(1, "Milan", "Celikovic",

					"milancel@uns.ac.rs");
		else

			return new BankClientBean();
	}

}

package com.iktpreobuka.restexamples.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.restexamples.entities.BankClientBean;

@Controller
@RestController
@RequestMapping("/bankclients")
public class BankClientRestController {



@RequestMapping(method = RequestMethod.GET)
public List<BankClientBean> getAll()  {
     List<BankClientBean> clients = new ArrayList<BankClientBean>();
clients.add(new BankClientBean(1, "Milan", "Celikovic",
		"milancel@uns.ac.rs"));
clients.add(new BankClientBean(2, "Vladimir", "Dimitreski",
		"dimitreski@uns.ac.rs"));
return clients;
}
/*
@RequestMapping(method = RequestMethod.GET, value = "/{clientId}")
public BankClientBean getByID(@PathVariable String clientId) {
	if(clientId.equals("1"))
		return new BankClientBean(1, "MIlan", "Celikovic",
				"milancel@uns.ac.rs");
	else
		return new BankClientBean(); */


protected List<BankClientBean> getDB() { 
List<BankClientBean> clients = new ArrayList<BankClientBean>(); 
    clients.add(new BankClientBean(1, "Milan", "Celikovic",     
		"milancel@uns.ac.rs")); 
    clients.add(new BankClientBean(2, "Vladimir",  "Dimitrieski",
       "dimitrieski@uns.ac.rs")); 
    return clients;  }  


@RequestMapping(method=RequestMethod.GET, value = "/{clientId}")
public BankClientBean getById(@PathVariable String clientId) { 
	for(BankClientBean bcb : getDB())   
	if(bcb.getId().equals(Integer.parseInt(clientId))) 
		return bcb;  
	return new BankClientBean(); 
}



@RequestMapping(method = RequestMethod.POST)
public String add(@RequestBody BankClientBean client) { 
	System.out.println(client.getName().concat(" "
			).concat(client.getSurname()));  
	return "New client added"; 
}
/*
@RequestMapping(method = RequestMethod.POST) 
public String add(@RequestBody BankClientBean client) {
	System.out.println(client.getName().concat(" ").concat(client.getSurname())); 
	return client.getName().concat(" ").concat(client.getSurname()); } 
*/
@RequestMapping(method = RequestMethod.PUT, value = "/{clientId}")
public BankClientBean modify(@PathVariable String clientId,
		@RequestBody BankClientBean client) {  
	  BankClientBean bcb = new BankClientBean(1, "Milan", "Celikovic", 
			  "milancel@uns.ac.rs");
	  if(clientId.equals("1")) {  
		  bcb.setName(client.getName());
		  return bcb; 
		  } else
			  return null; 
	  }

@RequestMapping(method = RequestMethod.DELETE, value = "/{clientId}") 
public BankClientBean delete(@PathVariable String clientId) {  
	for(BankClientBean bcb : getDB())
		if(bcb.getId().equals(Integer.parseInt(clientId))) {  
			getDB().remove(bcb);  
			return bcb;  
			}  
	return new BankClientBean(); } 



@RequestMapping(method = RequestMethod.GET, value = "/client") 
public BankClientBean getByNameSurname(@RequestParam("name") String name,
		@RequestParam("surname") String surname) { 
	if(name.equals("Milan") && surname.equals("Celikovic")) 
		return new BankClientBean(1, "Milan", "Celikovic", 
				"milancel@uns.ac.rs");   
	else 
		return new BankClientBean();
}

@RequestMapping(method = RequestMethod.GET, value = "/emails")
public List<String> emails () {
	List<String> emails = new ArrayList<String>();
for (BankClientBean bcb : getDB()) {
	emails.add(bcb.getEmail());
}
return emails;
}

@RequestMapping(method = RequestMethod.GET, value = "/clients/{firstLetter}")
public List<String> namesByFirstLetter(@PathVariable String firstLetter) {
	List<String> names = new ArrayList<String>();
	for(BankClientBean bcb : getDB()) {
		if(bcb.getName().startsWith(firstLetter)) {
			names.add(bcb.getName());
		}
	}
	return names;
		}

@RequestMapping(method = RequestMethod.GET, value = "/clients/firstLetters")
public List<String> nameSurnameByFirstLetter (@RequestParam("nameFirstLetter") String nameFirstLetter, @RequestParam("surnameFirstLetter") String surnameFirstLetter){
	List<String> clients = new ArrayList<String>();
	for(BankClientBean bcb : getDB()) {
		if (bcb.getName().startsWith(nameFirstLetter) && bcb.getSurname().startsWith(surnameFirstLetter) ) {
			clients.add(bcb.getName().concat(" ").concat(bcb.getSurname()));
		}
		}
	return clients;
	}

@RequestMapping(method = RequestMethod.GET, value = "/clients/sort/{order}")
public List<String> sortByOrder (@PathVariable String order) {
	List<String> clients = new ArrayList<String>();
	for(BankClientBean bcb : getDB()) {
		clients.add(bcb.getName()) ;
	}
	if(order.contentEquals("asc")) {
		Collections.sort(clients);
	}
	else
		if(order.contentEquals("desc")) {
			Collections.sort(clients, Collections.reverseOrder());
		}
	return clients;
	}


@RequestMapping(method = RequestMethod.PUT, value = "/clients/bonitet")
public @ResponseBody List<BankClientBean> bonitet() throws ParseException {
	List<BankClientBean> clients = new ArrayList<BankClientBean>();
	for(BankClientBean bcb : getDB()) {
		Date dateOfBirth = BankClientBean.dateParsing(bcb.getBirthDate());
		if (BankClientBean.getYearsBetween(dateOfBirth, new Date()) > 65) {
			bcb.setBonitet("N");
			clients.add(bcb);
		} else {
			bcb.setBonitet("P");
			clients.add(bcb);
		}
	}
	return clients;
		}


	
	}
		

	


package com.iktpreobuka.serialization.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.serialization.entities.AddressEntitiy;
import com.iktpreobuka.serialization.entities.UserEntity;
import com.iktpreobuka.serialization.security.Views;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	public List<UserEntity> getDummyDB() {
		List<UserEntity> users = new ArrayList<>();

		AddressEntitiy addr = new AddressEntitiy();
		addr.setId(1);
		addr.setStreet("Glavna Ulica 1");
		addr.setCity("Novi Sad");
		addr.setCountry("Srbija");
		addr.setVersion(1);

		UserEntity user1 = new UserEntity();
		user1.setId(1);
		user1.setDateOfBirth(new Date());
		user1.setEmail("user@example.com");
		user1.setName("Vladimir");
		user1.setPassword("password1234");
		user1.setVersion(1);
		user1.setAddress(addr);

		user1.setAddress(addr);
		/* addr.getUsers().add(user1); */

		users.add(user1);

		UserEntity user2 = new UserEntity();
		user2.setId(2);
		user2.setDateOfBirth(
				new Date()); /* Calendar calendar = Calendar.getInstance() */ /* desing pattern - sabloni */
		user2.setEmail("user2@example.com"); /* calendar.set(1965, month, 5, 15) */
		user2.setName("Milan");
		user2.setPassword("password1234");
		user2.setVersion(1);
		user2.setAddress(addr);

		user2.setAddress(addr);
		/* addr.getUsers().add(user2); */

		return users;

	}

	@RequestMapping(method = RequestMethod.GET)
	@JsonView(Views.Public.class)
	public List<UserEntity> getUsers() {
		return getDummyDB();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/private")
	@JsonView(Views.Private.class)
	public List<UserEntity> getUsersForPrivate() {
		return getDummyDB();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/admin")
	@JsonView(Views.Admin.class)
	public List<UserEntity> getUsersForAdmin() {
		return getDummyDB();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@JsonView(Views.Admin.class)
	public ResponseEntity<?> getUserByID(@PathVariable Integer userId) {
		// dodji do baze podataka
		List<UserEntity> users = getDummyDB();
		// TODO pronadji korisnika sa idejem
		for (UserEntity userEntity : users) {
			if (userEntity.getId().equals(userId)) {
				return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
			}
			
		}


	// TODO vrati korisnika
	// TODO ako korisnika nema vrati null



}
}

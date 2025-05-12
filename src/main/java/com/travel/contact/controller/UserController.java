package com.travel.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.contact.model.User;
import com.travel.contact.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	// Registers the users
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) throws Exception {
		if (user != null) {
			userService.registerUser(user);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Get all the registered users.
	@GetMapping("/users")
	public ResponseEntity<List<User>> getRegisteredUser() throws Exception {
		List<User> users = userService.getRegisteredUsers();
		if (users != null) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

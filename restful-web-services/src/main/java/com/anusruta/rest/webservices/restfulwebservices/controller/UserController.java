package com.anusruta.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.RequestEntity.HeadersBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anusruta.rest.webservices.restfulwebservices.dao.UserDao;

import com.anusruta.rest.webservices.restfulwebservices.beans.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDao dao;
	
	
	// Get details of all the users
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return dao.findAll();
	}
	
	
	// Get details of a specific user
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable Integer id) {
		return dao.findOne(id);
	}
	
	//Create a new user
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = dao.save(user);
		
//		URI location =  ServletUriComponentsBuilder
//			.fromCurrentRequest()
//			.path("/{id}")
//			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.of(Optional.of(savedUser));
	}
}

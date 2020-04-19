package com.myorg.spring.useraction.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.spring.useraction.api.exception.UserNotFoundException;
import com.myorg.spring.useraction.api.model.User;
import com.myorg.spring.useraction.api.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping(value = "/save")
	public User saveUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@GetMapping("/getUsers")
	public List<User> findAllUsers() {
		return service.getUsers();
	}

	@GetMapping("/getUserByAddress/{address}")
	public List<User> findUserByAddress(@PathVariable String address)
			throws UserNotFoundException {

		List<User> user = service.getUserbyAddress(address);
		if (user.size() <= 0) {
			throw new UserNotFoundException(
					"user not found with given address: " + address);
		}
		return user;
	}

	@DeleteMapping(value = "/remove")
	public User removeUser(@RequestBody User user) {
		service.deleteUser(user);
		return user;
	}
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);

	}
}

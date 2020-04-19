package com.myorg.spring.useraction.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myorg.spring.useraction.api.dao.UserRepository;
import com.myorg.spring.useraction.api.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User addUser(User user) {
		return repository.save(user);
	}

	public List<User> getUsers() {
		List<User> users = repository.findAll();
		System.out.println("Getting data from DB : " + users);
		return users;
	}

	public List<User> getUserbyAddress(String address) {
		return repository.findByAddress(address);
	}

	public void deleteUser(User user) {
		repository.delete(user);
	}
	public User updateUser(User user) {
		return repository.save(user);
	}
}

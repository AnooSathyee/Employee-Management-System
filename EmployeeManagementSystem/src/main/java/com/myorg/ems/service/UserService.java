package com.myorg.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myorg.ems.model.User;
import com.myorg.ems.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public void save(User user) {
		repo.save(user);
	}

	//Method to get a particular user details based on his email
	public User findByEmail(String email) {
		return repo.findByEmail(email);	 

	}

}

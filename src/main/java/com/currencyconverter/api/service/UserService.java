package com.currencyconverter.api.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.currencyconverter.api.entity.User;
import com.currencyconverter.api.repository.UserRepository;

@Service
public class UserService {
	
	@Inject
	private UserRepository userRepository;
	
	public User findById(int id) {
		return this.userRepository.findById(id);
	}

}

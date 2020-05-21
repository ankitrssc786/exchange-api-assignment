package com.currencyconverter.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.currencyconverter.api.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	User findById(int id);

}

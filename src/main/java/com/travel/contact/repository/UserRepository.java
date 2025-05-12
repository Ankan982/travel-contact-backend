package com.travel.contact.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travel.contact.model.User;


public interface UserRepository extends MongoRepository<User, String> 
{
    
}

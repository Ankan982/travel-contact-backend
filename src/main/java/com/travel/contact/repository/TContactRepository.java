package com.travel.contact.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travel.contact.model.Contact;


public interface TContactRepository extends MongoRepository<Contact, String>  {

}

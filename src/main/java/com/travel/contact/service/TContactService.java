package com.travel.contact.service;

import java.util.List;

import com.travel.contact.model.Contact;


public interface TContactService {

	public Contact createContact(Contact tContact) throws Exception;
    public List<Contact> getContactDetails() throws Exception;
}

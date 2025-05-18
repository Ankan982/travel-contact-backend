package com.travel.contact.service;

import java.util.List;

import com.travel.contact.model.Contact;
import com.travel.contact.model.GetContactDetailResponse;


public interface TContactService {

	public Contact createContact(Contact tContact) throws Exception;
    public GetContactDetailResponse getContactDetails() throws Exception;
}

package com.travel.contact.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.contact.model.Contact;
import com.travel.contact.model.GetContactDetailResponse;
import com.travel.contact.service.TContactService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contact/V1")
public class ContactController {
	
	@Autowired
	private  TContactService tContactService;
	
	@PostMapping("/saveContact")
	public ResponseEntity<Contact> saveContact(@RequestBody Contact tContact) throws Exception {
		if (tContact != null) {
			//validation to be build on email & phone no
			tContact.setCreatedDate(new Date());
			tContact.setSourceSystem("Website");
			tContactService.createContact(tContact);
			return new ResponseEntity<>(tContact, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Get all the registered users.
	@GetMapping("/getContacts")
	public ResponseEntity<GetContactDetailResponse> getAllContact() throws Exception {
		GetContactDetailResponse contactDtls = tContactService.getContactDetails();
		if (contactDtls != null) {
			return new ResponseEntity<>(contactDtls, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

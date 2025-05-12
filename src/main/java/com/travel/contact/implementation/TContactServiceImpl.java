package com.travel.contact.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.contact.model.Contact;
import com.travel.contact.repository.TContactRepository;
import com.travel.contact.service.TContactService;

@Service
public class TContactServiceImpl implements TContactService {

	
	@Autowired
    private TContactRepository tContactRepository;

	
	@Override
	public Contact createContact(Contact tContact) throws Exception {
		// TODO Auto-generated method stub
		if(null!=tContact)
		{
			
			return tContactRepository.save(tContact);
		}
		  throw new Exception("Contact Details is null");
	}

	@Override
	public List<Contact> getContactDetails() throws Exception {
		
		List<Contact> lstContacts=tContactRepository.findAll();
        if(null!=lstContacts && lstContacts.size()>0)
        {
        	return lstContacts;
        }
        throw new Exception("Contacts is null");
	}

	

}

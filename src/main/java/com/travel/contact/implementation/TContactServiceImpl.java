package com.travel.contact.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.contact.model.Contact;
import com.travel.contact.model.GetContactDetailResponse;
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
	public GetContactDetailResponse getContactDetails() throws Exception {
		
		GetContactDetailResponse getContactDetailResponse = new GetContactDetailResponse();
		List<Contact> lstContacts=tContactRepository.findAll();
		
		String totalQueryCount="0";
		String websiteCount="0";
		String otherCount="0";
		
        if(null!=lstContacts && lstContacts.size()>0)
        {
        	totalQueryCount = String.valueOf(lstContacts.size());
        	websiteCount = String.valueOf( lstContacts.stream().filter(p-> p.getSourceSystem().equalsIgnoreCase("Website")).count() );
        	otherCount=  String.valueOf(Long.valueOf(lstContacts.size())- lstContacts.stream().filter(p-> p.getSourceSystem().equalsIgnoreCase("Website")).count() );
        	getContactDetailResponse.setLstContactDetails(lstContacts);
        	getContactDetailResponse.setTotalQueryCount(totalQueryCount);
        	getContactDetailResponse.setTotalWebsiteQueryCount(websiteCount);
        	getContactDetailResponse.setOtherQueryCount(otherCount);
        	
        	return getContactDetailResponse;
        }
        throw new Exception("Contacts is null");
	}

	

}

package com.travel.contact.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.contact.model.Contact;
import com.travel.contact.model.User;
import com.travel.contact.repository.UserRepository;
import com.travel.contact.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) throws Exception 
    {
        if(user!=null)
        {
            return userRepository.save(user);
        }
        throw new Exception("User is null");
    }

    @Override
    public List<User> getRegisteredUsers() throws Exception 
    {
        List<User>users=userRepository.findAll();
        if(users!=null)
        {
            return users;
        }
        throw new Exception("User is null");
    }

	

	
}

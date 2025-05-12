package com.travel.contact.service;

import java.util.List;

import com.travel.contact.model.User;

public interface UserService {

	public User registerUser(User user) throws Exception;
    public List<User>getRegisteredUsers() throws Exception;
}

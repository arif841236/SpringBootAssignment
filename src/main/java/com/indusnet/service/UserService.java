package com.indusnet.service;


import com.indusnet.entity.User;
import com.indusnet.exeption.UserException;

public interface UserService {

	public User saveUser(User user) throws UserException;
	
}

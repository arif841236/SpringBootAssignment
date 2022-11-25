package com.indusnet.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.indusnet.entity.User;
import com.indusnet.exeption.UserException;
import com.indusnet.reposetry.UserDao;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserDao uDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UserException {
		User user =uDao.findByUsername(username);
		if (user == null) {
            throw new UserException("User not found with "+username +"and password: " + user.getPassword());
        }
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

}

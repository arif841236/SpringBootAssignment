package com.indusnet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.indusnet.entity.User;
import com.indusnet.exeption.UserException;
import com.indusnet.reposetry.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao uDao;

	@Override
	public User saveUser(User u) {
		Optional<User> user=uDao.findById(u.getUser_id());
		if(user.isPresent()) {
			
			throw new UserException("User are existed in the database..");
			}
		else {
		    return	uDao.save(u);
			
		}
		
	}

	
	
	

}

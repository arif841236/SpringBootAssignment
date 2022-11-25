package com.indusnet.service;

import java.util.List;
import com.indusnet.entity.User_Details;
import com.indusnet.exeption.ResponceException;
import com.indusnet.exeption.UserException;


public interface UserDetailService {

	public String addMember(User_Details user)throws ResponceException;
	
	public User_Details getUserDetailsByUserId(Integer id) throws UserException;
	
	public List<User_Details> getAllUserMember() throws ResponceException;
}

package com.indusnet.service;

import com.indusnet.entity.User;
import com.indusnet.exeption.UserException;

public interface LoginService {

	public String login(User u) throws UserException;
}

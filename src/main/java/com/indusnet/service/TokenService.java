package com.indusnet.service;

import com.indusnet.entity.UserLoginDetails;
import com.indusnet.exeption.UserException;

public interface TokenService {

	public String addToken(UserLoginDetails tEntity) throws UserException;
}

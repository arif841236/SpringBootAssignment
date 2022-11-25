package com.indusnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indusnet.entity.UserLoginDetails;
import com.indusnet.exeption.UserException;
import com.indusnet.reposetry.UserLoginRepository;

@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private UserLoginRepository tDao;
	
	@Override
	public String addToken(UserLoginDetails tEntity) throws UserException {
		String msg = "Not Added in the table ...";
		tDao.save(tEntity);
		
		msg = "Added succefully";
		
		return msg;
		
		
	}

}

package com.indusnet.service;

import com.indusnet.entity.ShortUrlResponce;
import com.indusnet.entity.User_Details;
import com.indusnet.exeption.UserException;

public interface UrlService {

	public ShortUrlResponce generateShortLink(User_Details user) throws UserException;
  
}

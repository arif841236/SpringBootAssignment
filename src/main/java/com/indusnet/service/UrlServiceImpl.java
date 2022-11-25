package com.indusnet.service;



import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indusnet.entity.ShortUrlResponce;
import com.indusnet.entity.User;
import com.indusnet.entity.User_Details;
import com.indusnet.exeption.UserException;
import com.indusnet.reposetry.ShortUrlRepository;
import com.indusnet.tiny.Tiny;


@Service
public class UrlServiceImpl implements UrlService {

	@Autowired
	private Tiny tService;
	
	@Autowired
	private ShortUrlRepository shortDao;
	
	@Override
	public ShortUrlResponce generateShortLink(User_Details userDetails) throws UserException {
		User user = userDetails.getUser();
		String encodedUrl =null;
		ShortUrlResponce shortUrlDetails = shortDao.getShortUrlResponce(user.getUser_id());
		if(StringUtils.isNotEmpty(userDetails.getLinkedIn())) {
			encodedUrl = tService.shortUrl(userDetails.getLinkedIn());
			}
		
		ShortUrlResponce shortUrlResponce = null;
		
		if(encodedUrl!=null) {
			shortUrlResponce = new ShortUrlResponce(0, userDetails.getUser(), "success", 200, encodedUrl);
			
		}
		else {
			shortUrlResponce = new ShortUrlResponce(0, userDetails.getUser(), "error", 401, encodedUrl);
		}
		
		ShortUrlResponce shortUrl=null;
		if(shortUrlDetails!=null) {
			shortDao.delete(shortUrlDetails);
			shortUrl=shortDao.save(shortUrlResponce);
		}
		else {
			 shortUrl=shortDao.save(shortUrlResponce);

		}
		
		return shortUrl;
	}

}

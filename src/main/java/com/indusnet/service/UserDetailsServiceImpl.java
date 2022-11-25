package com.indusnet.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indusnet.entity.ShortUrlResponce;
import com.indusnet.entity.User_Details;
import com.indusnet.exeption.ResponceException;
import com.indusnet.exeption.UserException;
import com.indusnet.reposetry.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailsRepository userDetailsRepo;
	
	@Autowired
	private UrlService urlService;
	
	@Override
	public String addMember(User_Details userDetails) throws ResponceException {
		User_Details existedUserDetail = userDetailsRepo.getUserDetailsById(userDetails.getUser().getUser_id());
		User_Details uMember=null;
		ShortUrlResponce shortEntity=urlService.generateShortLink(userDetails);
		String shortUrl= shortEntity.getShort_Url();
		if(existedUserDetail!=null) {
			uMember= new User_Details(existedUserDetail.getId(),existedUserDetail.getUser(), userDetails.getName(), userDetails.getMobile(), userDetails.getEmail(), shortUrl, existedUserDetail.getCreated_date(), LocalDateTime.now());
			}
		else {
			uMember = new User_Details(userDetails.getUser(), userDetails.getName(), userDetails.getMobile(), userDetails.getEmail(), shortUrl, LocalDateTime.now(), LocalDateTime.now());
		}
		userDetailsRepo.save(uMember);
			return shortUrl;
	}

	@Override
	public User_Details getUserDetailsByUserId(Integer id) throws UserException {
		
		User_Details userDetails= userDetailsRepo.getUserDetailsById(id);
		if(userDetails==null) {
			throw new UserException("User is not found with :"+id);
		}
		else {
			return userDetails;
		}
		//return userDetailsRepo.getUserDetailsById(id).orElseThrow(()-> new UserException("User is not found with :"+id));
		
	}

	@Override
	public List<User_Details> getAllUserMember() throws ResponceException {
		List<User_Details> allUser=userDetailsRepo.findAll();
		if(allUser==null) {
			throw new ResponceException("");
		}
		else {
			return allUser;
		}
		
	}

}

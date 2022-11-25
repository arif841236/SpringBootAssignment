package com.indusnet.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.indusnet.entity.UserLoginDetails;
import com.indusnet.entity.User;
import com.indusnet.exeption.ResponceException;
import com.indusnet.jwtUtil.JwtUtil;
import com.indusnet.reposetry.UserDao;
import com.indusnet.reposetry.UserLoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserLoginRepository userLoginRepo;
	    
	@Override
	public String login(User user) throws ResponceException {
		
		try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        } 
		catch (ResponceException ex) {
            throw new ResponceException("");
        }
				
       UserLoginDetails existedUserLoginDetails = userLoginRepo.findByUser_Id(user.getUser_id());
       String token=jwtUtil.generateToken(user.getUsername());
       UserLoginDetails userLoginDetails = null;
		if(existedUserLoginDetails ==null) {
		   userLoginDetails.setUser(user);
		   userLoginDetails.setToken(token);
		   userLoginDetails.setStatus("success");
		   userLoginDetails.setCreated_at(LocalDateTime.now());
	   }
	   else {
		 userLoginDetails = new UserLoginDetails(existedUserLoginDetails.getId(),user,token ,"success" , LocalDateTime.now());
		}
		userLoginRepo.save(userLoginDetails);
		 return token;
       
	}

}

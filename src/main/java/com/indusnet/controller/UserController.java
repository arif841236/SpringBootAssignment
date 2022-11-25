package com.indusnet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.indusnet.dto.UserDto;
import com.indusnet.entity.User;
import com.indusnet.exeption.ResponceError;
import com.indusnet.exeption.ResponceException;
import com.indusnet.reposetry.UserDao;
import com.indusnet.service.LoginService;
import com.indusnet.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService uService;
	
    @Autowired
    private LoginService lService;
    
    @Autowired
    private UserDao uDao;
	
	@PostMapping("/signup")
	  public User addUserHandler(@RequestBody @Valid User user) {
		return uService.saveUser(user);
	  }
	
	@PostMapping("/login")
    public ResponseEntity<ResponceError> generateToken(@RequestBody UserDto authRequest) throws Exception {
        User user=uDao.findByUsernameAndPassword(authRequest.getUsername(), authRequest.getPassword());
		if(user != null) {
			String token=lService.login(new User(user.getUser_id(), user.getUsername(), user.getPassword()));
			ResponceError response = new ResponceError(200, "Login Successfully", token);
			return new ResponseEntity<ResponceError>(response, HttpStatus.ACCEPTED);
		}
		else {
			throw new ResponceException("");
		}
	
    }
	
}

package com.indusnet.controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.indusnet.dto.GetAllUserDetails;
import com.indusnet.dto.GetUserDetail;
import com.indusnet.dto.Responce;
import com.indusnet.dto.UserDetailDto;
import com.indusnet.entity.UserLoginDetails;
import com.indusnet.entity.User_Details;
import com.indusnet.exeption.ResponceException;
import com.indusnet.reposetry.UserLoginRepository;
import com.indusnet.service.UserDetailService;

@RestController
public class UserDetailsController {

	@Autowired
	private UserDetailService userDetailSerice;
	
	@Autowired
	private UserLoginRepository userLoginRepo;
	
	@PostMapping("/add")
	public ResponseEntity<Responce> addUserDetails(@RequestBody @Valid UserDetailDto user,HttpServletRequest http) throws Exception {
		String token = http.getHeader("Authorization");
        token = token.replaceAll("Bearer ", "");
		UserLoginDetails userLogin = userLoginRepo.findByToken(token);
		if(userLogin!=null) {
			String shortUrl = userDetailSerice.addMember(new User_Details(userLogin.getUser(), user.getName(), user.getMobile(), user.getEmail(), user.getLinkedIn(), LocalDateTime.now(), LocalDateTime.now()));	
	        Responce responce= new Responce(200, "Successfully added the data");
			return new ResponseEntity<Responce>(responce, HttpStatus.ACCEPTED);
		}
		else {
			throw new ResponceException("");
		}
		
	}
	
	@GetMapping("/userDetails")
	public ResponseEntity<GetAllUserDetails> getUserDetails(HttpServletRequest http) {
		String token = http.getHeader("Authorization");
        token = token.replaceAll("Bearer ", "");
		UserLoginDetails userLogin = userLoginRepo.findByToken(token);
		if(userLogin!=null) {
			User_Details userDetail=userDetailSerice.getUserDetailsByUserId(userLogin.getUser().getUser_id());
			List<GetUserDetail> uList = new ArrayList<>();
			
			uList.add(new GetUserDetail(userDetail.getId(), userDetail.getUser().getUser_id(), userDetail.getName(),userDetail.getMobile(), userDetail.getEmail(), userDetail.getLinkedIn(), userDetail.getCreated_date(), userDetail.getUpdated_date()));
			
			GetAllUserDetails responce = new GetAllUserDetails(200, "Success",uList );
			return new ResponseEntity<GetAllUserDetails>(responce, HttpStatus.OK);
		}
		else {
			throw new ResponceException("");
		}
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<GetAllUserDetails>  getAllUsersDetails(){
		List<User_Details> list = userDetailSerice.getAllUserMember();
		if(list!=null) {
			List<GetUserDetail> uList = new ArrayList<>();
			list.forEach(l -> {
				uList.add(new GetUserDetail(l.getId(), l.getUser().getUser_id(), l.getName(),l.getMobile(), l.getEmail(), l.getLinkedIn(), l.getCreated_date(), l.getUpdated_date()));
			});
			GetAllUserDetails responce = new GetAllUserDetails(200, "Success",uList );
			return new ResponseEntity<GetAllUserDetails>(responce, HttpStatus.OK);
		}
		else {
			throw new ResponceException("");
		}
		
	}
}

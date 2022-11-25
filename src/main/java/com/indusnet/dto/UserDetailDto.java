package com.indusnet.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDetailDto {

	@Size(min=2, max=16, message="Name length should be 2 to 16")
	private String name;
	
	@Size(min=10, max=10, message="Mobile number should be 10 digit")
	@Pattern(regexp = "^\\d{10}$")
	private String mobile;
	
	@Email
	//@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message="Email Not Valid.")
	private String email;
	
	private String linkedIn;

//	public UserDetailDto(Integer user_Id,
//			@Size(min = 2, max = 16, message = "Name length should be 2 to 16") String name,
//			@Size(min = 10, max = 10, message = "Mobile number should be 10 digit") @Pattern(regexp = "^\\d{10}$") String mobile,
//			@Email String email) {
//		super();
//		this.user_Id = user_Id;
//		this.name = name;
//		this.mobile = mobile;
//		this.email = email;
//	}
	
	
	
}

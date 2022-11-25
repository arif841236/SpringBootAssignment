package com.indusnet.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@Size(min = 4, max = 16, message = "please enter valid username")
	@NotBlank(message = "Please fill the username...")
	private String username;
	
	@Size(min = 4, max = 16,message = "please enter valid password")
	@NotBlank(message = "password should be required")
	private String password;
}

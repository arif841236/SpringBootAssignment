package com.indusnet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "id")
	private Integer user_id;
	
	@Size(min = 4, max = 16, message = "please enter valid username")
	@NotBlank(message = "Please fill the username...")
	private String username;
	
	@Size(min = 4, max = 16,message = "please enter valid password")
	@NotBlank(message = "password should be required")
	private String password;
	
	
	
}

package com.indusnet.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_login_token")
public class UserLoginDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Integer id;
	@OneToOne
	private User user;
	private String token;
	private String status;
	private LocalDateTime created_at;
	public UserLoginDetails(User user, String token, String status, LocalDateTime created_at) {
		super();
		this.user = user;
		this.token = token;
		this.status = status;
		this.created_at = created_at;
	}
	
	
}

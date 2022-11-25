package com.indusnet.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity

public class User_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToOne
	private User user;
	private String name;
	private String mobile;
	private String email;
	private String linkedIn;
	private LocalDateTime created_date;
	private LocalDateTime updated_date;
	public User_Details(User user, String name, String mobile, String email, String linkedIn,
			LocalDateTime created_date, LocalDateTime updated_date) {
		super();
		this.user = user;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.linkedIn = linkedIn;
		this.created_date = created_date;
		this.updated_date = updated_date;
	}
}

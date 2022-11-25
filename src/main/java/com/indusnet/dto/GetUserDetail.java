package com.indusnet.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetUserDetail {

	private Integer id;
	private Integer user_Id;
	private String name;
	private String mobile;
	private String email;
	private String linkedIn;
	private LocalDateTime created_date;
	private LocalDateTime updated_date;
}

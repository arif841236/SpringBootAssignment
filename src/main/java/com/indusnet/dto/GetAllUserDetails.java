package com.indusnet.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetAllUserDetails {

	private Integer responseCode;
	private String responseMessage;
	private List<GetUserDetail> data;
}

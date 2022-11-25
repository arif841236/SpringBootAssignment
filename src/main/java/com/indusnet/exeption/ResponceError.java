package com.indusnet.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponceError {

	private Integer responseCode;
	private String responseMessage;
	private String authToken;
	
	
	
}

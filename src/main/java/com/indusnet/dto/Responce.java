package com.indusnet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Responce {

	private Integer responseCode;
	private String responseMessage;
	
}

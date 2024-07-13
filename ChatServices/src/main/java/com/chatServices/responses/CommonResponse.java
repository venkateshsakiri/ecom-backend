package com.chatServices.responses;

import java.util.Optional;

import lombok.Data;

@Data
public class CommonResponse {
	
	public String message;
	
	public Optional<?> statusCode;

}

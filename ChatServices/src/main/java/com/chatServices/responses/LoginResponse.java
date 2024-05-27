package com.chatServices.responses;




import com.chatServices.entity.Users;

import lombok.Data;

@Data
public class LoginResponse {

	public String status;
	
	public String message;
	
	public String applicationType;
	
	public Users user;
	
	
}

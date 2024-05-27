package com.chatServices.responses;

import java.util.List;

import com.chatServices.entity.Users;

public class UserResponse {
	
	public String status;
	
	public String message;
	
	public Integer count;
	
	public List<Users> allUsers;

	public UserResponse(String status, String message, Integer count, List<Users> allUsers) {
		super();
		this.status = status;
		this.message = message;
		this.count = count;
		this.allUsers = allUsers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Users> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(List<Users> allUsers) {
		this.allUsers = allUsers;
	}

	/**
	 * 
	 */
	public UserResponse() {
		super();
		
	}
	
	

}

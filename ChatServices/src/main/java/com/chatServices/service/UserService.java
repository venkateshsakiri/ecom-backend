package com.chatServices.service;

import java.util.List;

import com.chatServices.entity.Users;

public interface UserService {

	String upsert(Users user);
	
	Users existCreateUser(String email);
	
	String deleteUserById(Long id);
	
	Boolean isEmailExist(String email);
	
	List<Users> getAllUsers();
	
	Users updateUser(Long id, Users user);
	
	

}

package com.chatServices.controller;



import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chatServices.entity.Users;
import com.chatServices.enums.UserRole;
import com.chatServices.responses.LoginResponse;
import com.chatServices.responses.UserResponse;
import com.chatServices.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	
	
	@RequestMapping(value="/create", headers="Accept=*/*",produces = "application/json",method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody Users user) {
		try {
			Boolean isExistUser = userService.isEmailExist(user.email);				
					if(isExistUser) {
						return new ResponseEntity<>("User already exists",HttpStatus.NOT_ACCEPTABLE);
					}else {
						Users usersss = new Users();
						usersss.email = user.email;
						usersss.name = user.name;
						usersss.password = user.password;
						usersss.id = user.id;
						usersss.UserRole = UserRole.CUSTOMER;
						String status = userService.upsert(usersss);
						return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(status);
					}					
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured while retrieving information");
		}
		
	}
	
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> delateUserById(@PathVariable Long id) {
		String status = userService.deleteUserById(id);
		return new ResponseEntity<String>(status,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllRegisteredUsers(){
		List<Users> users = userService.getAllUsers();
		HashMap<String, String> removePassword = new HashMap<>();
		for(Users user:users) {
			removePassword.remove("password",user.password);
		}
		UserResponse userResponse = new UserResponse();
		userResponse.message = "All users fetched successfully!";
		userResponse.setStatus("SUCCESS");
		userResponse.setCount(users.size());
		userResponse.setAllUsers(users);
		return ResponseEntity.ok(userResponse);
		
	}
	
	
	@RequestMapping(value="/login", headers="Accept=*/*",produces = "application/json",method = RequestMethod.POST)
	public ResponseEntity<?> loginUser(@RequestBody Users user) {
		try {
			Boolean isExistUser = userService.isEmailExist(user.email);			
					if(isExistUser) {
						Users users = userService.existCreateUser(user.email);
						if(user.password.equalsIgnoreCase(users.password)) {
							LoginResponse loginResponse = new LoginResponse();
							loginResponse.applicationType ="CHAT";
							loginResponse.message = "logged in Successfully!";
							loginResponse.status = "SUCCESS";
							loginResponse.user = users;
							
							return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(loginResponse);
							
						}else {
							return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Incorrect password.");
						}
						
					}else {
						return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Email Incorrect.");
					}					
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured while retrieving information");
		}
		
	}
	
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateAccount(@PathVariable Long id, @RequestBody Users user){
		 Users status = userService.updateUser(id, user);
		 return new ResponseEntity<Users>(status,HttpStatus.OK);
	}
	
	
	 

}

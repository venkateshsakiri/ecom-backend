package com.chatServices.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatServices.entity.Users;
import com.chatServices.entity.repo.UsersRepository;
import com.chatServices.service.UserService;

@Service
public class UserServiceImpls implements UserService{
	
	@Autowired
	public UsersRepository usersRepository;
	
	@Override
	public String upsert(Users user) {
		usersRepository.save(user);
		return "Account details added successfully";
	
	}

	@Override
	public Users existCreateUser(String email) {
	return usersRepository.findByEmail(email);
	
	}

	@Override
	public String deleteUserById(Long id) {
		if(usersRepository.existsById(id)) {
			usersRepository.deleteById(id);
			return "User deleted successfully!";
		}else {
			return "No records found";
		}
	}

	@Override
	public Boolean isEmailExist(String email) {
		return usersRepository.existsByEmail(email);
	}

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}



	@Override
	public Users updateUser(Long id, Users user) {
		if(usersRepository.existsById(id)) {
			return usersRepository.save(user);
		}
		return null;
	}
	
	
	
}

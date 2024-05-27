package com.chatServices.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatServices.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	public Users findByEmail(String email);
	
	public Boolean existsByEmail(String email);

}

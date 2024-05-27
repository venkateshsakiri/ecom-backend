package com.chatServices.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatServices.entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer>{

}

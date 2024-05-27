package com.chatServices.service;

import java.util.List;

import com.chatServices.entity.Chat;
import com.chatServices.entity.Message;

public interface ChatService {
	
	 public Chat addChat(Chat chat);
	 
	 public Message addMeaasge(Message message);
	 
	 public List<Message> getAllMessages();
	 
	 List<Message> findMessagesBySenderAndReceiver(String senderEmail, String receiverEmail);
	 
//	 recent chats
	 List<Message> findMessagesBySenderOrReceiver(String email);
	 
	 List<Message> findMessagesBetweenUsers(String senderEmail, String receiverEmail);

}

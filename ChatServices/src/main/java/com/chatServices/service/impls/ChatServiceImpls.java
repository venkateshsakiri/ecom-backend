package com.chatServices.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatServices.entity.Chat;
import com.chatServices.entity.Message;
import com.chatServices.entity.repo.ChatRepository;
import com.chatServices.entity.repo.MessageRepository;
import com.chatServices.service.ChatService;

@Service
public class ChatServiceImpls implements ChatService{
	
	@Autowired
    private ChatRepository chatRepository;
	
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public Chat addChat(Chat chat) {
		return chatRepository.save(chat);
	}

	@Override
	public Message addMeaasge(Message message) {
		return messageRepository.save(message);
	}

	@Override
	public List<Message> getAllMessages() {
		return messageRepository.findAll();
	}
	
	@Override
	 public List<Message> findMessagesBySenderAndReceiver(String senderEmail, String receiverEmail) {
	        return messageRepository.findBySenderEmailAndReceiverEmail(senderEmail, receiverEmail);
	 }

	
//	 recents chats
	@Override
	public List<Message> findMessagesBySenderOrReceiver(String email) {
		return messageRepository.findBySenderOrReceiverEmail(email);
	}

	@Override
	public List<Message> findMessagesBetweenUsers(String senderEmail, String receiverEmail) {
	    return messageRepository.findMessagesBetweenUsers(senderEmail, receiverEmail);
	}

}

package com.chatServices.controller;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketHandler;

import com.chatServices.config.CustomWebSocketHandler;
import com.chatServices.entity.Chat;
import com.chatServices.entity.Message;
import com.chatServices.entity.Users;
import com.chatServices.service.ChatService;
import com.chatServices.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	public ChatService chatService;
	
	@Autowired
	public UserService userService;
	
	 @Autowired
	    private CustomWebSocketHandler webSocketHandler;
	
	@PostMapping("/add")
	public ResponseEntity<Chat> createChat(@RequestBody Chat chat) throws IOException{
		try {
            return new ResponseEntity<Chat>(chatService.addChat(chat), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Chat Already Exist", HttpStatus.CONFLICT);
        }
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> addChatting(@RequestBody Message message){
		try {
			Message savedMessage = chatService.addMeaasge(message);
			List<Message> msgs = chatService.getAllMessages();
			Users userDetails = userService.existCreateUser(message.senderEmail);
			Users receiverDetails = userService.existCreateUser(message.receiverEmail);
			Chat chat = new Chat(userDetails.id, receiverDetails.id, msgs);
			chatService.addChat(chat);
			  if (webSocketHandler != null) {
		            webSocketHandler.broadcastMessage(savedMessage);
		        }
			return new ResponseEntity<>(savedMessage,HttpStatus.CREATED);
		}catch (Exception e) {
            return new ResponseEntity("Chat Already Exist", HttpStatus.CONFLICT);
        }
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllChats(){
		return ResponseEntity.ok(chatService.getAllMessages());
	}
	
	
	@GetMapping("/get")
	public ResponseEntity<?> getSenderAndReceiverMessages( @RequestParam String senderEmail,
            @RequestParam String receiverEmail){
		List<Message> messages = chatService.findMessagesBySenderAndReceiver(senderEmail, receiverEmail);
        return ResponseEntity.ok(messages);
	}
	
	
//	recent messages
	@GetMapping("/get-recent-messages")
	public ResponseEntity<?> getSenderOrReceiverMessages( @RequestParam String email){
		List<Message> messages = chatService.findMessagesBySenderOrReceiver(email);
        return ResponseEntity.ok(messages);
	}
	
//	messages b/w 2 users
	@GetMapping("/findMessagesBetweenUsers")
	public ResponseEntity<List<Message>> findMessagesBetweenUsers(@RequestParam String senderEmail, @RequestParam String receiverEmail) {
	    List<Message> messages = chatService.findMessagesBetweenUsers(senderEmail, receiverEmail);
	    return ResponseEntity.ok(messages);
	}

	
	
	

}

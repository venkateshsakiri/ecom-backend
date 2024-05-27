package com.chatServices.config;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.chatServices.entity.Message;
import com.chatServices.service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomWebSocketHandler extends TextWebSocketHandler {

	private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
	@Autowired
    private ChatService chatService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Message chatMessage = objectMapper.readValue(message.getPayload(), Message.class);
        System.out.println("sakiriiiiiiiiiiii");
        // Save the message to the database
//        chatService.addMeaasge(chatMessage);

        // Broadcast the message to all connected clients
        TextMessage broadcastMessage = new TextMessage(objectMapper.writeValueAsString(chatMessage));
        for (WebSocketSession s : sessions) {
            s.sendMessage(broadcastMessage);
        }
    }

    public void broadcastMessage(Message message) throws IOException {
        TextMessage textMessage = new TextMessage(new ObjectMapper().writeValueAsString(message));
        for (WebSocketSession session : sessions) {
            session.sendMessage(textMessage);
        }
    }

}

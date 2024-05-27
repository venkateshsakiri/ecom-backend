package com.chatServices.entity;

import java.util.Date;

import org.springframework.web.socket.WebSocketMessage;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "messages")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String senderEmail;
	public String receiverEmail;
    public Date time = new Date(System.currentTimeMillis());
    public String replymessage;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chat_id")
    public Chat chat;
}

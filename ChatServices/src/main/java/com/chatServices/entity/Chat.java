package com.chatServices.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "chat")
public class Chat {
	
//	@Transient
//    public static final String SEQUENCE_NAME = "chat_sequence";
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int chatId;
	    public Long senderId;
	    public Long receiverId;
	    
	    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    public List<Message> messageList;

		public Long getSenderId() {
			return senderId;
		}

		public void setSenderId(Long senderId) {
			this.senderId = senderId;
		}

		public Long getReceiverId() {
			return receiverId;
		}

		public void setReceiverId(Long receiverId) {
			this.receiverId = receiverId;
		}

		public List<Message> getMessageList() {
			return messageList;
		}

		public void setMessageList(List<Message> messageList) {
			this.messageList = messageList;
		}

		/**
		 * @param senderId
		 * @param receiverId
		 * @param messageList
		 */
		public Chat(Long senderId, Long receiverId, List<Message> messageList) {
			this.senderId = senderId;
			this.receiverId = receiverId;
			this.messageList = messageList;
		}
	    
	    
		
	    

}

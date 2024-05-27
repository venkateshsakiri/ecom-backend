package com.chatServices.entity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chatServices.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	
	List<Message> findBySenderEmailAndReceiverEmail(String senderEmail, String receiverEmail);

//	we can use of recent chats 
	@Query("SELECT m FROM Message m WHERE m.senderEmail = :email OR m.receiverEmail = :email")
    List<Message> findBySenderOrReceiverEmail(String email);
	
	
	@Query("SELECT m FROM Message m WHERE (m.senderEmail = :senderEmail AND m.receiverEmail = :receiverEmail) OR (m.senderEmail = :receiverEmail AND m.receiverEmail = :senderEmail)")
    List<Message> findMessagesBetweenUsers(@Param("senderEmail") String senderEmail, @Param("receiverEmail") String receiverEmail);
}

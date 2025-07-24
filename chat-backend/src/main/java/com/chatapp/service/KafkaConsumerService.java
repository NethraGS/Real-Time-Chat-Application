package com.chatapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public KafkaConsumerService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @KafkaListener(topics = "chat-messages", groupId = "chat_group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        messagingTemplate.convertAndSend("/topic/public", message);
    }
}

package com.chatapp.controller;

import com.chatapp.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public ChatController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka");
    }
}

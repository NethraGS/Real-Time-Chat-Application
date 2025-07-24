package com.chatapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatBackendApplication {

	public static void main(String[] args) {
		System.out.println("hi there");
		SpringApplication.run(ChatBackendApplication.class, args);
	}

}

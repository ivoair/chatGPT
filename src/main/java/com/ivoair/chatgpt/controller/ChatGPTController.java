package com.ivoair.chatgpt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivoair.chatgpt.model.request.ChatGPTRequest;
import com.ivoair.chatgpt.model.response.ChatGptResponse;
import com.ivoair.chatgpt.service.ChatGPTService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/chatGPT")
@RequiredArgsConstructor
public class ChatGPTController {

	private final ChatGPTService chatGPTService;

    @PostMapping("/send")
    public ChatGptResponse sendMessage(@RequestBody ChatGPTRequest request) {

		return chatGPTService.askQuestion(request.getMessage());

    }
}




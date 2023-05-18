package com.ivoair.chatgpt.service;

import com.ivoair.chatgpt.model.response.ChatGptResponse;

public interface ChatGPTService {

	ChatGptResponse askQuestion(String prompt);

}

package com.ivoair.chatgpt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ivoair.chatgpt.model.request.OpenAIRequest;
import com.ivoair.chatgpt.model.response.ChatGptResponse;

@Service
public class ChatGPTServiceImpl implements ChatGPTService {

	@Value("${app.config.client.openai.model}")
	public String openAIModel;

	@Value("${app.config.client.openai.max-token}")
	public Integer openAIMaxToken;

	@Value("${app.config.client.openai.temperature}")
	public Double openAITemperature;

	@Value("${app.config.client.openai.top-p}")
	public Double openAITopP;

	@Autowired
	@Qualifier("openAIClient")
	private RestTemplate openAIClient;

	public ChatGptResponse askQuestion(String prompt) {

		OpenAIRequest openAIRequest = new OpenAIRequest(this.openAIModel, prompt, this.openAITemperature,
				this.openAIMaxToken, this.openAITopP);
		
		ResponseEntity<ChatGptResponse> responseEntity = openAIClient.postForEntity("/completions",
				new HttpEntity<>(openAIRequest),
				ChatGptResponse.class);

		return responseEntity.getBody();

    }

}







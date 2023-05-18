package com.ivoair.chatgpt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ChatGptConfig {

	private static final String AUTHORIZATION = "Authorization";
	private static final String BEARER = "Bearer ";
	private static final String MEDIA_TYPE = "application/json; charset=UTF-8";

	@Value("${app.config.client.openai.url}")
	private String openAIUrl;

	@Value("${app.config.client.openai.api-key}")
	private String openAIKey;

	@Bean(name = "openAIClient")
	public RestTemplate openAIClient() {

		return new RestTemplateBuilder(rt -> rt.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
			request.getHeaders().add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + this.openAIKey);
			return execution.execute(request, body);
		})).rootUri(this.openAIUrl).build();

	}

}

package com.ivoair.chatgpt.model.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class ChatGPTRequest implements Serializable {

	private static final long serialVersionUID = 4465039993627040564L;

	private String message;

}




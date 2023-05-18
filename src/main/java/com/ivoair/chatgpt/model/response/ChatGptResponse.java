package com.ivoair.chatgpt.model.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class ChatGptResponse implements Serializable {

	private static final long serialVersionUID = -3221506712037794082L;

	private String id;

    private String object;

    private String model;

    private LocalDate created;

    private List<Choice> choices;
}





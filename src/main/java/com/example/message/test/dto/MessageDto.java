package com.example.message.test.dto;

import lombok.Data;

@Data
public class MessageDto {
	private Long participantId;
	private Long conversationId;
	private String messageText;
}

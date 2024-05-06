package com.example.message.test.service;

import java.util.List;

import com.example.message.test.dto.ConversationDto;
import com.example.message.test.model.Conversation;

public interface ConversationService {
	List<Conversation> findAllConversation();

	Conversation addConversation(ConversationDto conversationDto);

	Conversation updateConversation(Long id, ConversationDto conversationDto);

	String deleteConversation(Long id);
}

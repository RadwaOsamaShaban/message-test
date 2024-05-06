package com.example.message.test.service;

import java.util.List;

import com.example.message.test.dto.MessageDto;
import com.example.message.test.model.Message;

public interface MessageService {
	List<Message> findAllMessage();

	Message addMessage(MessageDto messageDto);

	Message updateMessage(Long id, MessageDto messageDto);

	String deleteMessage(Long id);

	String getMessagesPerDayReport();
}

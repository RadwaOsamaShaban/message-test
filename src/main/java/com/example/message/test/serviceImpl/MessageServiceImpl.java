package com.example.message.test.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.message.test.dto.MessageDto;
import com.example.message.test.model.Conversation;
import com.example.message.test.model.Message;
import com.example.message.test.repository.ConversationRepo;
import com.example.message.test.repository.MessageRepo;
import com.example.message.test.service.MessageService;
import com.example.message.test.util.ExportMessagesReportUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

	private final ConversationRepo conversationRepo;

	private final MessageRepo messageRepo;

	@Override
	public String getMessagesPerDayReport() {

		// find all coversations
		List<Long> conversations = conversationRepo.findAll().stream().map(Conversation::getId).toList();
		// find list of massages by conversation id
		List<Message> messages = messageRepo.findAllByConversationIdIn(conversations);
		// create map with date as key and number of message per day as value
		Map<String, Integer> messagesPerDay = new HashMap<>();
		messages.stream().forEach(m -> {
			String date = m.getCreateAt().toString();
			messagesPerDay.put(date, messagesPerDay.getOrDefault(date, 0) + 1);
		});
		// generate excel file
		ExportMessagesReportUtil.generateMessagePerDayReport(messagesPerDay);
		return "Export Done";
	}

	@Override
	public List<Message> findAllMessage() {
		return messageRepo.findAll();
	}

	@Override
	public Message addMessage(MessageDto messageDto) {
		Message message = new Message();
		message.setMessageText(messageDto.getMessageText());
		message.setParticipantId(messageDto.getParticipantId());
		message.setConversationId(messageDto.getConversationId());
		message.setCreateAt(new Date());
		return messageRepo.save(message);
	}

	@Override
	public Message updateMessage(Long id, MessageDto messageDto) {
		Optional<Message> message = messageRepo.findById(id);
		if (message.isPresent()) {
			message.get().setMessageText(messageDto.getMessageText());
			message.get().setParticipantId(messageDto.getParticipantId());
			message.get().setConversationId(messageDto.getConversationId());
			return messageRepo.save(message.get());
		}
		return null;
	}

	@Override
	public String deleteMessage(Long id) {
		messageRepo.deleteById(id);
		return "Delete Done";
	}
}

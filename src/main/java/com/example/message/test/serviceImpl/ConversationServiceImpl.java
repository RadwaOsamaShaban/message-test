package com.example.message.test.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.message.test.dto.ConversationDto;
import com.example.message.test.model.Conversation;
import com.example.message.test.repository.ConversationRepo;
import com.example.message.test.service.ConversationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConversationServiceImpl implements ConversationService {
	private final ConversationRepo conversationRepo;

	@Override
	public List<Conversation> findAllConversation() {
		return conversationRepo.findAll();
	}

	@Override
	public Conversation addConversation(ConversationDto conversationDto) {
		Conversation con = new Conversation();
		con.setTitle(conversationDto.getTitle());
		con.setCreateAt(new Date());
		return conversationRepo.save(con);
	}

	@Override
	public Conversation updateConversation(Long id, ConversationDto conversationDto) {
		Optional<Conversation> con = conversationRepo.findById(id);
		if (con.isPresent()) {
			con.get().setTitle(conversationDto.getTitle());
			con.get().setLastUpdate(new Date());
			return conversationRepo.save(con.get());
		}
		return null;
	}

	@Override
	public String deleteConversation(Long id) {
		conversationRepo.deleteById(id);
		return "Delete Done";
	}

}

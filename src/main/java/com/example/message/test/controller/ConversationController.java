package com.example.message.test.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.message.test.dto.ConversationDto;
import com.example.message.test.model.Conversation;
import com.example.message.test.payload.PagedResponse;
import com.example.message.test.payload.SingleResponse;
import com.example.message.test.service.ConversationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/private")
@AllArgsConstructor
public class ConversationController {

	private final ConversationService conversationService;

	@GetMapping("/conversaction/all")
	public PagedResponse<Conversation> findAllConversation() {
		return new PagedResponse<>(conversationService.findAllConversation());
	}

	@PostMapping("/conversaction/add")
	public SingleResponse<Conversation> addConversation(@RequestBody ConversationDto conversationDto) {
		return new SingleResponse<>(conversationService.addConversation(conversationDto));
	}

	@PutMapping("/conversaction/{id}/update")
	public SingleResponse<Conversation> updateConversation(@PathVariable Long id,
			@RequestBody ConversationDto conversationDto) {
		return new SingleResponse<>(conversationService.updateConversation(id, conversationDto));
	}

	@DeleteMapping("/conversaction/{id}/delete")
	public SingleResponse<String> deleteConversation(@PathVariable Long id) {
		return new SingleResponse<>(conversationService.deleteConversation(id));
	}
}

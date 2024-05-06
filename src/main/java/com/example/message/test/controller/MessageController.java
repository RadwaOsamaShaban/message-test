package com.example.message.test.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.message.test.dto.MessageDto;
import com.example.message.test.model.Message;
import com.example.message.test.payload.PagedResponse;
import com.example.message.test.payload.SingleResponse;
import com.example.message.test.service.MessageService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/private")
@AllArgsConstructor
public class MessageController {

	private final MessageService messageService;

	@GetMapping("/message/all")
	public PagedResponse<Message> findAllMessage() {
		return new PagedResponse<>(messageService.findAllMessage());
	}

	@PostMapping("/message/add")
	public SingleResponse<Message> addMessage(@RequestBody MessageDto messageDto) {
		return new SingleResponse<>(messageService.addMessage(messageDto));
	}

	@PutMapping("/message/{id}/update")
	public SingleResponse<Message> updateMessage(@PathVariable Long id, @RequestBody MessageDto messageDto) {
		return new SingleResponse<>(messageService.updateMessage(id, messageDto));
	}

	@DeleteMapping("/message/{id}/delete")
	public SingleResponse<String> deleteMessage(@PathVariable Long id) {
		return new SingleResponse<>(messageService.deleteMessage(id));
	}

	@GetMapping("/export")
	public SingleResponse<String> getMessagesPerDayReport() {
		return new SingleResponse<>(messageService.getMessagesPerDayReport());
	}
}

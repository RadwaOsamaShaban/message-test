package com.example.message.test.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.message.test.dto.ParticipantDto;
import com.example.message.test.model.Participant;
import com.example.message.test.payload.PagedResponse;
import com.example.message.test.payload.SingleResponse;
import com.example.message.test.service.ParticipantService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/private")
@AllArgsConstructor
public class ParticipantController {

	private final ParticipantService participantService;

	@GetMapping("/participant/all")
	public PagedResponse<Participant> findAllParticipant() {
		return new PagedResponse<>(participantService.findAllParticipant());
	}

	@PostMapping("/participant/add")
	public SingleResponse<Participant> addParticipant(@RequestBody ParticipantDto participantDto) {
		return new SingleResponse<>(participantService.addParticipant(participantDto));
	}

	@PutMapping("/participant/{id}/update")
	public SingleResponse<Participant> updateParticipant(@PathVariable Long id,
			@RequestBody ParticipantDto participantDto) {
		return new SingleResponse<>(participantService.updateParticipant(id, participantDto));
	}

	@DeleteMapping("/participant/{id}/delete")
	public SingleResponse<String> deleteParticipant(@PathVariable Long id) {
		return new SingleResponse<>(participantService.deleteParticipant(id));
	}
}

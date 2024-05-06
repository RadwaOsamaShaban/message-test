package com.example.message.test.service;

import java.util.List;

import com.example.message.test.dto.ParticipantDto;
import com.example.message.test.model.Participant;

public interface ParticipantService {
	List<Participant> findAllParticipant();

	Participant addParticipant(ParticipantDto participantDto);

	Participant updateParticipant(Long id, ParticipantDto participantDto);

	String deleteParticipant(Long id);
}

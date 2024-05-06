package com.example.message.test.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.message.test.dto.ParticipantDto;
import com.example.message.test.model.Participant;
import com.example.message.test.repository.ParticipantRepo;
import com.example.message.test.service.ParticipantService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

	private final ParticipantRepo participantRepo;

	@Override
	public List<Participant> findAllParticipant() {
		return participantRepo.findAll();
	}

	@Override
	public Participant addParticipant(ParticipantDto participantDto) {
		Participant participant = new Participant();
		participant.setName(participantDto.getName());
		participant.setEmail(participantDto.getEmail());
		participant.setMobile(participantDto.getMobile());
		return participantRepo.save(participant);
	}

	@Override
	public Participant updateParticipant(Long id, ParticipantDto participantDto) {
		Optional<Participant> participant = participantRepo.findById(id);
		if (participant.isPresent()) {
			participant.get().setName(participantDto.getName());
			participant.get().setEmail(participantDto.getEmail());
			participant.get().setMobile(participantDto.getMobile());
			return participantRepo.save(participant.get());
		}
		return null;
	}

	@Override
	public String deleteParticipant(Long id) {
		participantRepo.deleteById(id);
		return "Delete Done";
	}
}

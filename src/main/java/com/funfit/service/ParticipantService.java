package com.funfit.service;

import java.util.List;

import com.funfit.bean.Participant;
import com.funfit.dao.ParticipantDao;

public class ParticipantService {
	ParticipantDao participantDao = new ParticipantDao();

	public String addParticipants(Participant participant) {
		if (participantDao.addParticipant(participant) > 0) {
			return "Participants details added successfully";
		} else {
			return "Participants details didn't add";
		}
	}

	public List<Participant> viewAllParticipants() {
		return participantDao.viewAllParticipants();
	}
}

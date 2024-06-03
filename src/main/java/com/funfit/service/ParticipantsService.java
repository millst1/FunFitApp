package com.funfit.service;

import java.util.List;

import com.funfit.bean.Participants;
import com.funfit.dao.ParticipantsDao;

public class ParticipantsService {
	ParticipantsDao pd = new ParticipantsDao();

	public String addParticipants(Participants participants) {
		if (pd.addParticipants(participants) > 0) {
			return "Participants details added successfully";
		} else {
			return "Participants details didn't add";
		}
	}

	public List<Participants> viewAllParticipants() {
		return pd.viewAllParticipants();
	}
}

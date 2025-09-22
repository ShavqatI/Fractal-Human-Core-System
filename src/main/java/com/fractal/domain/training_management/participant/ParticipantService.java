package com.fractal.domain.training_management.participant;

import com.fractal.domain.training_management.participant.dto.ParticipantCompactResponse;

public interface ParticipantService {
    Participant getById(Long id);
    ParticipantCompactResponse toCompactDTO(Participant participant);
}

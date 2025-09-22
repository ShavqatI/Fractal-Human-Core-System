package com.fractal.domain.training_management.participant.external.mapper;

import com.fractal.domain.training_management.participant.Participant;
import com.fractal.domain.training_management.participant.dto.ParticipantCompactResponse;
import com.fractal.domain.training_management.participant.external.ExternalParticipant;
import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantCompactResponse;
import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantRequest;
import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantResponse;

public interface ExternalParticipantMapperService {
    ExternalParticipantResponse toDTO(ExternalParticipant trainer);
    ExternalParticipantCompactResponse toCompactDTO(ExternalParticipant trainer);
    ParticipantCompactResponse toCompactDTO(Participant participant);
    ExternalParticipant toEntity(ExternalParticipantRequest dto);
    ExternalParticipant toEntity(ExternalParticipant trainer, ExternalParticipantRequest dto);
}



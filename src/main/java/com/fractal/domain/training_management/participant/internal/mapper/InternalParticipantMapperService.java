package com.fractal.domain.training_management.participant.internal.mapper;

import com.fractal.domain.training_management.participant.Participant;
import com.fractal.domain.training_management.participant.dto.ParticipantCompactResponse;
import com.fractal.domain.training_management.participant.internal.InternalParticipant;
import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantCompactResponse;
import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantRequest;
import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantResponse;

public interface InternalParticipantMapperService {
    InternalParticipantResponse toDTO(InternalParticipant trainer);
    InternalParticipantCompactResponse toCompactDTO(InternalParticipant trainer);
    ParticipantCompactResponse toCompactDTO(Participant participant);
    InternalParticipant toEntity(InternalParticipantRequest dto);
    InternalParticipant toEntity(InternalParticipant trainer, InternalParticipantRequest dto);
}



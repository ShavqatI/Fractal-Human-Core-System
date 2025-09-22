package com.fractal.domain.training_management.participant.internal;

import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantCompactResponse;
import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantRequest;
import com.fractal.domain.training_management.participant.internal.dto.InternalParticipantResponse;

import java.util.List;

public interface InternalParticipantService {
    InternalParticipant create(InternalParticipantRequest dto);
    List<InternalParticipant> getAll();
    InternalParticipant getById(Long id);
    InternalParticipant update(Long id, InternalParticipantRequest dto);
    void deleteById(Long id);
    InternalParticipantResponse toDTO(InternalParticipant trainer);
    InternalParticipantCompactResponse toCompactDTO(InternalParticipant trainer);


}

package com.fractal.domain.training_management.participant.external;

import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantCompactResponse;
import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantRequest;
import com.fractal.domain.training_management.participant.external.dto.ExternalParticipantResponse;

import java.util.List;

public interface ExternalParticipantService {
    ExternalParticipant create(ExternalParticipantRequest dto);
    List<ExternalParticipant> getAll();
    ExternalParticipant getById(Long id);
    ExternalParticipant update(Long id, ExternalParticipantRequest dto);
    void deleteById(Long id);
    ExternalParticipantResponse toDTO(ExternalParticipant trainer);
    ExternalParticipantCompactResponse toCompactDTO(ExternalParticipant trainer);
    ExternalParticipant save(ExternalParticipant trainer);


}

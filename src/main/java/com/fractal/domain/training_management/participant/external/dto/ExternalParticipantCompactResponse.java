package com.fractal.domain.training_management.participant.external.dto;

public record ExternalParticipantCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) {
}

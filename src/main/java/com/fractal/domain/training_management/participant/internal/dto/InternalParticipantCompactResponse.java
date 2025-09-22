package com.fractal.domain.training_management.participant.internal.dto;

public record InternalParticipantCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) {

}

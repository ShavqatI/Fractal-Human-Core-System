package com.fractal.domain.training_management.participant.dto;

public record ParticipantCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) {
}

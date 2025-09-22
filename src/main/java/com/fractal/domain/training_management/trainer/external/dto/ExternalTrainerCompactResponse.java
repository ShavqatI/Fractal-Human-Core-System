package com.fractal.domain.training_management.trainer.external.dto;

public record ExternalTrainerCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) {
}

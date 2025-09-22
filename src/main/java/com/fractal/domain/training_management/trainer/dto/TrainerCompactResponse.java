package com.fractal.domain.training_management.trainer.dto;

public record TrainerCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) {
}

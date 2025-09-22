package com.fractal.domain.training_management.trainer.internal.dto;

public record InternalTrainerCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) {

}

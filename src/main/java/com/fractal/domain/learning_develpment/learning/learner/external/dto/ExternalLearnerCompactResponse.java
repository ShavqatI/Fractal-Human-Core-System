package com.fractal.domain.learning_develpment.learning.learner.external.dto;

public record ExternalLearnerCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) {
}

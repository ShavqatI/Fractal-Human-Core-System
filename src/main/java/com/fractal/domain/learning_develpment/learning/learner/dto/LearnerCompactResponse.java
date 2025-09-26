package com.fractal.domain.learning_develpment.learning.learner.dto;

public record LearnerCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) {
}

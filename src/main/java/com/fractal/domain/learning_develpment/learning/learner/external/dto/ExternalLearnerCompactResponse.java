package com.fractal.domain.learning_develpment.learning.learner.external.dto;

import com.fractal.domain.learning_develpment.learning.learner.dto.LearnerCompactResponse;

public record ExternalLearnerCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) implements LearnerCompactResponse {
}

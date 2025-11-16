package com.fractal.domain.learning_develpment.learning.learner.internal.dto;

import com.fractal.domain.learning_develpment.learning.learner.dto.LearnerCompactResponse;

public record InternalLearnerCompactResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName
) implements LearnerCompactResponse {
}

package com.fractal.domain.learning_develpment.learning.session.enrollment.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.dto.LearnerCompactResponse;

import java.time.LocalDateTime;

public record LearningSessionEnrollmentResponse(
        Long id,
        LearnerCompactResponse learner,
        LocalDateTime startTime,
        LocalDateTime endTime,
        StatusCompactResponse status,
        LocalDateTime createdDate
)
{ }

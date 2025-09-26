package com.fractal.domain.learning_develpment.learning.session.enrollment.dto;

import java.time.LocalDateTime;

public record LearningSessionEnrollmentRequest(
        Long learnerId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Long statusId

) { }

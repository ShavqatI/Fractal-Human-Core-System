package com.fractal.domain.learning_develpment.learning.session.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.learning_develpment.learning.delivery_mode.dto.LearningDeliveryModeResponse;

import java.time.LocalDateTime;

public record LearningSessionCompactResponse(
        Long id,
        LearningDeliveryModeResponse learningDeliveryMode,
        LocalDateTime startTime,
        LocalDateTime endTime,
        StatusCompactResponse status
)
{ }

package com.fractal.domain.learning_develpment.learning.dto;

import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionRequest;

import java.time.LocalDateTime;
import java.util.List;

public record LearningRequest(
        Long learningTypeId,
        Long learningCategoryId,
        Long learningLevelId,
        Long learningDeliveryModeId,
        String code,
        String title,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer capacity,
        Boolean mandatory,
        List<LearningSessionRequest> sessions,
        Long statusId

) { }

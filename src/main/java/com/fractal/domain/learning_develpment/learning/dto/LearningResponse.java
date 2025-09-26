package com.fractal.domain.learning_develpment.learning.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryCompactResponse;
import com.fractal.domain.learning_develpment.learning.delivery_mode.dto.LearningDeliveryModeResponse;
import com.fractal.domain.learning_develpment.learning.level.dto.LearningLevelResponse;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionResponse;
import com.fractal.domain.learning_develpment.learning.type.dto.LearningTypeResponse;

import java.time.LocalDateTime;
import java.util.List;

public record LearningResponse(
        Long id,
        LearningTypeResponse learningType,
        LearningCategoryCompactResponse learningCategory,
        LearningLevelResponse learningLevel,
        LearningDeliveryModeResponse learningDeliveryMode,
        String code,
        String title,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer capacity,
        Boolean mandatory,
        List<LearningSessionResponse> sessions,
        StatusCompactResponse status,
        LocalDateTime createdDate
)
{ }

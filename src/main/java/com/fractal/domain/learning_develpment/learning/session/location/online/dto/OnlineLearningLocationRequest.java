package com.fractal.domain.learning_develpment.learning.session.location.online.dto;

import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationRequest;

import java.time.LocalDateTime;

public record OnlineLearningLocationRequest(
        Long onlinePlatformId,
        String url,
        String username,
        String password,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer capacity,
        Long statusId
) implements LearningLocationRequest {
}

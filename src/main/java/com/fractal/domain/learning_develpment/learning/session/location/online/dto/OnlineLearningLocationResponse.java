package com.fractal.domain.learning_develpment.learning.session.location.online.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.learning_develpment.learning.platform.dto.OnlinePlatformResponse;
import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationResponse;
import com.fractal.domain.learning_develpment.learning.session.location.type.dto.LearningLocationTypeResponse;

import java.time.LocalDateTime;

public record OnlineLearningLocationResponse(
        Long id,
        LearningLocationTypeResponse locationTypeResponse,
        OnlinePlatformResponse onlinePlatform,
        String url,
        String username,
        String password,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer capacity,
        StatusCompactResponse status,
        LocalDateTime createdDate

) implements LearningLocationResponse { }

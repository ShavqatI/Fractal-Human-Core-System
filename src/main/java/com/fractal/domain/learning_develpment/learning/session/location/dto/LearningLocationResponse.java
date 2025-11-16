package com.fractal.domain.learning_develpment.learning.session.location.dto;


import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.learning_develpment.learning.session.location.type.dto.LearningLocationTypeResponse;

import java.time.LocalDateTime;


public interface LearningLocationResponse {
    Long id();

    LearningLocationTypeResponse locationTypeResponse();

    Integer capacity();

    LocalDateTime startTime();

    LocalDateTime endTime();

    StatusCompactResponse status();

    LocalDateTime createdDate();
}

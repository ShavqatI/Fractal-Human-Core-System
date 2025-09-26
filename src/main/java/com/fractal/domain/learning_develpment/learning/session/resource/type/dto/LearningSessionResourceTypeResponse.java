package com.fractal.domain.learning_develpment.learning.session.resource.type.dto;

import java.time.LocalDateTime;

public record LearningSessionResourceTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

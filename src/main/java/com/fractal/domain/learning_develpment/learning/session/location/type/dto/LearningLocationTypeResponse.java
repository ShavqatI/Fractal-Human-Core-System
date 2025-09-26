package com.fractal.domain.learning_develpment.learning.session.location.type.dto;

import java.time.LocalDateTime;

public record LearningLocationTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

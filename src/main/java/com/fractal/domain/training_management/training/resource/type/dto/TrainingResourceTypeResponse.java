package com.fractal.domain.training_management.training.resource.type.dto;

import java.time.LocalDateTime;

public record TrainingResourceTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

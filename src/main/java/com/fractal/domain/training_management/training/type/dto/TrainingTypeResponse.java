package com.fractal.domain.training_management.training.type.dto;

import java.time.LocalDateTime;

public record TrainingTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

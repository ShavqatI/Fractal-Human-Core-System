package com.fractal.domain.training_management.training.location.type.dto;

import java.time.LocalDateTime;

public record TrainingLocationTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

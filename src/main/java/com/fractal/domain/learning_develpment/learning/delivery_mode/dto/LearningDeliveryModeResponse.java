package com.fractal.domain.learning_develpment.learning.delivery_mode.dto;

import java.time.LocalDateTime;

public record LearningDeliveryModeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

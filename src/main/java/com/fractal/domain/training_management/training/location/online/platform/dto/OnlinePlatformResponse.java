package com.fractal.domain.training_management.training.location.online.platform.dto;

import java.time.LocalDateTime;

public record OnlinePlatformResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

package com.fractal.domain.learning_develpment.learning.platform.type.dto;

import java.time.LocalDateTime;

public record OnlinePlatformTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

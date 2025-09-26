package com.fractal.domain.learning_develpment.learning.platform.dto;

import com.fractal.domain.learning_develpment.learning.platform.type.dto.OnlinePlatformTypeResponse;

import java.time.LocalDateTime;

public record OnlinePlatformResponse(
        Long id,
        String code,
        String name,
        OnlinePlatformTypeResponse onlinePlatformType,
        LocalDateTime createdDate

) {

}

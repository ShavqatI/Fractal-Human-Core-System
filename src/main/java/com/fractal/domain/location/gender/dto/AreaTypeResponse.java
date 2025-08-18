package com.fractal.domain.location.gender.dto;

import java.time.LocalDateTime;

public record AreaTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

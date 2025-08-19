package com.fractal.domain.location.area_type.dto;

import java.time.LocalDateTime;

public record AreaTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

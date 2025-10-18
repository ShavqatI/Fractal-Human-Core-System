package com.fractal.domain.dictionary.measurement_unit.dto;

import java.time.LocalDateTime;

public record MeasurementUnitResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

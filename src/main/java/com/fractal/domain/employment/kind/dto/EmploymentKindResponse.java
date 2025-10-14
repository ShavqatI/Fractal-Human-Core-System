package com.fractal.domain.employment.kind.dto;

import java.time.LocalDateTime;

public record EmploymentKindResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

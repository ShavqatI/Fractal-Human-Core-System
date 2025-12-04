package com.fractal.domain.employment.state;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;


public record EmploymentStateResponse(
        Long id,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {

}

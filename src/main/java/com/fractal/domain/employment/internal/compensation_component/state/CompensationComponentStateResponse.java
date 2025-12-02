package com.fractal.domain.employment.internal.compensation_component.state;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;


public record CompensationComponentStateResponse(
        Long id,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {

}

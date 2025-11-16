package com.fractal.domain.vacation_management.request.state;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;


public record VacationRequestStateResponse(
        Long id,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {

}

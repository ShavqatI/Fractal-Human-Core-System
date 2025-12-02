package com.fractal.domain.employee_management.employment.state;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;


public record EmployeeEmploymentStateResponse(
        Long id,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {

}

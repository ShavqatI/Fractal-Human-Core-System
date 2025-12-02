package com.fractal.domain.employee_management.employee.state;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;


public record EmployeeStateResponse(
        Long id,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {

}

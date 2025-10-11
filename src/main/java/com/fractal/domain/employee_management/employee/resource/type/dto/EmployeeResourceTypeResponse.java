package com.fractal.domain.employee_management.employee.resource.type.dto;

import java.time.LocalDateTime;

public record EmployeeResourceTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

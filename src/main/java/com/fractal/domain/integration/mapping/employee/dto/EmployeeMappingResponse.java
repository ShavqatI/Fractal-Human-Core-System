package com.fractal.domain.integration.mapping.employee.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;

import java.time.LocalDateTime;

public record EmployeeMappingResponse(
        Long id,
        EmployeeCompactResponse employee,
        String referenceType,
        String reference,
        StatusCompactResponse status,
        LocalDateTime createdDate

) { }

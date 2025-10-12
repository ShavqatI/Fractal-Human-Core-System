package com.fractal.domain.employee_management.subordinate.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employee_management.subordinate.type.dto.SubordinateTypeResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SubordinateResponse(
        Long id,
        EmployeeCompactResponse employee,
        EmployeeCompactResponse subordinateEmployee,
        SubordinateTypeResponse subordinateType,
        StatusCompactResponse status,
        LocalDate startDate,
        LocalDate endDate,
        LocalDateTime createdDate
) {}

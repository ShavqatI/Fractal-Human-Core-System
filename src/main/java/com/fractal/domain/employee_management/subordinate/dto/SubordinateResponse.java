package com.fractal.domain.employee_management.subordinate.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SubordinateResponse(
        Long id,
        String employee,
        String subordinateEmployee,
        String subordinateType,
        String status,
        LocalDate startDate,
        LocalDate endDate,
        LocalDateTime createdDate
) {}

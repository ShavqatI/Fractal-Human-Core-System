package com.fractal.domain.employee_management.subordinate.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SubordinateRequest(
    @NotNull
    Long employeeId,
    @NotNull
    Long subordinateEmployeeId,
    Long subordinateTypeId,
    Long statusId,
    LocalDate startDate,
    LocalDate endDate
    )

{}

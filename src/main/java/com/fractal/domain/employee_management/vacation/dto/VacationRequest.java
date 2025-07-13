package com.fractal.domain.employee_management.vacation.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record VacationRequest(
    @NotNull
    Long employeeId,
    @NotNull
    Long successorEmployeeId,
    @NotNull
    Long vacationCategoryId,
    @NotNull
    Long vacationTypeId,
    Long statusId,
    LocalDate startDate,
    LocalDate endDate,
    Integer days,
    String orderNumber,
    LocalDate orderDate,
    String description

    )

{}
package com.fractal.domain.employee_management.vacation.dto;

import com.fractal.domain.employee_management.vacation.order.VacationOrder;
import com.fractal.domain.employee_management.vacation.order.dto.VacationOrderRequest;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record VacationRequest(
    @NotNull
    Long employeeId,
    @NotNull
    Long successorEmployeeId,
    @NotNull
    Long vacationCategoryId,
    @NotNull
    Long vacationTypeId,
    @NotNull
    LocalDate startDate,
    @NotNull
    LocalDate endDate,
    Integer days,
    List<VacationOrderRequest> orders,
    String description,
    Long statusId

    )

{}
package com.fractal.domain.vacation_management.schedule.dto;

import com.fractal.domain.vacation_management.order.dto.VacationOrderRequest;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record VacationScheduleRequest(
    @NotNull
    Long employeeId,
    @NotNull
    LocalDate startDate,
    @NotNull
    LocalDate endDate
    )
{}
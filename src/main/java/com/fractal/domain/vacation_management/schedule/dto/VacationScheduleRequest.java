package com.fractal.domain.vacation_management.schedule.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record VacationScheduleRequest(
        @NotNull
        Long employeeId,
        @NotNull
        LocalDate startDate,
        @NotNull
        LocalDate endDate
) {
}
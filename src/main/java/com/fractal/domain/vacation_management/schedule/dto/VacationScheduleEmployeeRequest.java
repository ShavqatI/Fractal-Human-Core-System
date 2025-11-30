package com.fractal.domain.vacation_management.schedule.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record VacationScheduleEmployeeRequest(
        @NotNull
        LocalDate startDate,
        @NotNull
        Integer days
) {
}
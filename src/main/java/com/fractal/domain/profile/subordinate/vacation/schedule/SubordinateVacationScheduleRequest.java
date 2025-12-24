package com.fractal.domain.profile.subordinate.vacation.schedule;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SubordinateVacationScheduleRequest(
        @NotNull
        Long employeeId,
        @NotNull
        LocalDate startDate,
        @NotNull
        Integer days
) {
}
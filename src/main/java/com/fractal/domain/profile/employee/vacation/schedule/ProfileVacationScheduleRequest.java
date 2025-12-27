package com.fractal.domain.profile.employee.vacation.schedule;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProfileVacationScheduleRequest(
        @NotNull
        LocalDate startDate,
        @NotNull
        Integer days
) {
}
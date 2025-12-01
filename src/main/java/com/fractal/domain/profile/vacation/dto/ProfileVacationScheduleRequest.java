package com.fractal.domain.profile.vacation.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProfileVacationScheduleRequest(
        @NotNull
        LocalDate startDate,
        @NotNull
        Integer days
) {
}
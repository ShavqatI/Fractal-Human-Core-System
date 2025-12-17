package com.fractal.domain.employment.punishment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PunishmentRequest(
        @NotNull
        Long punishmentTypeId,
        @NotBlank
        String description,
        BigDecimal amount,
        @NotNull
        LocalDate startDate,
        @NotNull
        LocalDate endDate

) {
}

package com.fractal.domain.organization_management.position.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PositionCancelRequest(
        @NotBlank
        String reason

) {

}

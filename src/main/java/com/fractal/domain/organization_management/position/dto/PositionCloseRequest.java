package com.fractal.domain.organization_management.position.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PositionCloseRequest(

        @NotNull
        LocalDate closeDate,
        @NotBlank
        String closeReason

) {

}

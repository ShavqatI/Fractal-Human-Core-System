package com.fractal.domain.employment.separation_reason.dto;

import jakarta.validation.constraints.NotNull;

public record SeparationReasonRequest(

    @NotNull
    Long separationReasonTypeId
)

{}

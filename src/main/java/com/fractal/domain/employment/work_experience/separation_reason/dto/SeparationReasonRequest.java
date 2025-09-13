package com.fractal.domain.employment.work_experience.separation_reason.dto;

import jakarta.validation.constraints.NotNull;

public record SeparationReasonRequest(

    @NotNull
    Long separationReasonTypeId
)

{}

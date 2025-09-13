package com.fractal.domain.employment.work_experience.separation_reason.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record SeparationReasonRequest(

    @NotNull
    Long separationReasonTypeId
)

{}

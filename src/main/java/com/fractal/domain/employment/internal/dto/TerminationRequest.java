package com.fractal.domain.employment.internal.dto;

import com.fractal.domain.employment.separation_reason.dto.SeparationReasonRequest;

import java.time.LocalDate;
import java.util.List;

public record TerminationRequest(
    LocalDate endDate,
    List<SeparationReasonRequest> separationReasons
)
{}

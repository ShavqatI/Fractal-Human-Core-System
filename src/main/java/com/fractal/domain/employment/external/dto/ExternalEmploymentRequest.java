package com.fractal.domain.employment.external.dto;

import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.punishment.dto.PunishmentRequest;
import com.fractal.domain.employment.separation_reason.dto.SeparationReasonRequest;

import java.time.LocalDate;
import java.util.List;

public record ExternalEmploymentRequest(
        Long countryId,
        String location,
        Long employmentTypeId,
        LocalDate startDate,
        LocalDate endDate,
        String organization,
        String department,
        String division,
        String position,
        String responsibilities,
        String achievements,
        List<SeparationReasonRequest> separationReasons,
        List<PunishmentRequest> punishments,
        Long statusId

) implements EmploymentRequest {
}

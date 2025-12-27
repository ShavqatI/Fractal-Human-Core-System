package com.fractal.domain.employment.internal.dto;

import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.agreement.employment.dto.EmploymentAgreementRequest;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;
import com.fractal.domain.employment.punishment.dto.PunishmentRequest;
import com.fractal.domain.employment.separation_reason.dto.SeparationReasonRequest;

import java.time.LocalDate;
import java.util.List;

public record InternalEmploymentRequest(
        Long organizationId,
        Long departmentId,
        Long positionId,
        Long employmentTypeId,
        LocalDate startDate,
        LocalDate endDate,
        List<EmploymentAgreementRequest> agreements,
        List<SeparationReasonRequest> separationReasons,
        List<PunishmentRequest> punishments,
        List<CompensationComponentRequest> compensationComponents


) implements EmploymentRequest {
}

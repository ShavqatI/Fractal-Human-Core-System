package com.fractal.domain.employment.internal.dto;

import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementRequest;
import com.fractal.domain.employment.internal.order.dto.InternalEmploymentOrderRequest;
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
        List<InternalEmploymentAgreementRequest> agreements,
        List<InternalEmploymentOrderRequest> orders,
        List<SeparationReasonRequest> separationReasons,
        Long statusId

) implements EmploymentRequest { }

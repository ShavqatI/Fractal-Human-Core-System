package com.fractal.domain.employee_management.employment.usecase.hire.dto;

import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;

import java.time.LocalDate;
import java.util.List;
public record HireRequest (
    Long organizationId,
    Long departmentId,
    Long positionId,
    Long employmentTypeId,
    LocalDate startDate,
    LocalDate endDate,
    List<CompensationComponentRequest> compensationComponents
) {}

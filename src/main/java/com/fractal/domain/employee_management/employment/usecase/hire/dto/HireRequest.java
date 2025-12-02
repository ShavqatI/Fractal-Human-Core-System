package com.fractal.domain.employee_management.employment.usecase.hire.dto;

import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class HireRequest {
    private Long organizationId;
    protected Long departmentId;
    protected Long positionId;
    protected Long employmentTypeId;
    protected LocalDate startDate;
    protected LocalDate endDate;
    List<CompensationComponentRequest> compensationComponents;
}

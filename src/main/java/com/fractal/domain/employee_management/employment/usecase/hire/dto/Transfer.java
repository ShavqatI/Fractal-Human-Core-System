package com.fractal.domain.employee_management.employment.usecase.hire.dto;

import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;

import java.time.LocalDate;
import java.util.List;

public class Transfer {
    protected Long departmentId;
    protected Long positionId;
    protected Long employmentTypeId;
    protected LocalDate startDate;
    protected LocalDate endDate;
    List<CompensationComponentRequest> compensationComponents;
}

package com.fractal.domain.employment.internal.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementResponse;
import com.fractal.domain.employment.internal.order.dto.InternalEmploymentOrderResponse;
import com.fractal.domain.employment.separation_reason.dto.SeparationReasonResponse;
import com.fractal.domain.employment.type.dto.EmploymentTypeCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.organization_management.position.dto.PositionCompactResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record InternalEmploymentResponse(
        Long id,
        String employmentKind,
        LocalDate startDate,
        LocalDate endDate,
        OrganizationCompactResponse organization,
        DepartmentCompactResponse department,
        PositionCompactResponse position,
        EmploymentTypeCompactResponse employmentType,
        List<InternalEmploymentAgreementResponse> agreements,
        List<InternalEmploymentOrderResponse> orders,
        List<SeparationReasonResponse> separationReasons,
        StatusCompactResponse status,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) implements EmploymentResponse { }

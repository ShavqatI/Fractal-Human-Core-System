package com.fractal.domain.employment.internal.dto;

import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employment.type.dto.EmploymentTypeCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.organization_management.position.dto.PositionCompactResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record InternalEmploymentApprovedResponse(
        Long id,
        EmployeeCompactResponse employeeCompactResponse,
        LocalDate startDate,
        LocalDate endDate,
        EmploymentTypeCompactResponse employmentType,
        OrganizationCompactResponse organization,
        DepartmentCompactResponse department,
        PositionCompactResponse position,
        LocalDateTime createdDate
){}

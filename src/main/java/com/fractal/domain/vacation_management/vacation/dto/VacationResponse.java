package com.fractal.domain.vacation_management.vacation.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import com.fractal.domain.vacation_management.vacation.allocation.dto.VacationAllocationResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VacationResponse(
        Long id,
        EmployeeCompactResponse employee,
        VacationRequestResponse vacationRequest,
        BigDecimal compensationPercentage,
        BigDecimal successorCompensationPercentage,
        List<VacationAllocationResponse> allocations,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}

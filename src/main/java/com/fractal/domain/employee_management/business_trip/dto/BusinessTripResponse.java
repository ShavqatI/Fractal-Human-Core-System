package com.fractal.domain.employee_management.business_trip.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseResponse;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationResponse;
import com.fractal.domain.employee_management.business_trip.type.dto.BusinessTripTypeResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record BusinessTripResponse(
        Long id,
        EmployeeCompactResponse employee,
        BusinessTripTypeResponse businessTripType,
        StatusCompactResponse status,
        String purpose,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        Integer days,

        List<BusinessTripExpenseResponse> expenses,
        List<BusinessTripLocationResponse> locations,
        List<ResourceResponse> resources,
        LocalDateTime createdDate
) {
}

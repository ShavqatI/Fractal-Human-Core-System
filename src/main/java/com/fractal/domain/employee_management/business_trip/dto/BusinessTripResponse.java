package com.fractal.domain.employee_management.business_trip.dto;

import com.fractal.domain.dictionary.status.dto.StatusResponse;
import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderResponse;
import com.fractal.domain.employee_management.business_trip.type.dto.BusinessTripTypeResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record BusinessTripResponse(
        Long id,
        BusinessTripTypeResponse businessTripTypeResponse,
        EmployeeCompactResponse employee,
        StatusResponse status,
        String purpose,
        String description,
        String location,
        LocalDate startDate,
        LocalDate endDate,
        Integer days,
        List<BusinessTripOrderResponse> orders,
        List<ResourceResponse> resources,
        LocalDateTime createdDate
) {
}

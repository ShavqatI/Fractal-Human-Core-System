package com.fractal.domain.integration.mapping.employee.dto;

public record EmployeeMappingRequest(
        Long employeeId,
        String referenceType,
        String reference,
        Long statusId
) {
}

package com.fractal.domain.integration.mapping.department.dto;

public record DepartmentMappingRequest(
        Long departmentId,
        String referenceType,
        String reference,
        Long statusId
) {
}

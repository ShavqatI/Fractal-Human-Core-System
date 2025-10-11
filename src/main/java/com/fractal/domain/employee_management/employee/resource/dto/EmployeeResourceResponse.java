package com.fractal.domain.employee_management.employee.resource.dto;

import com.fractal.domain.employee_management.employee.resource.type.dto.EmployeeResourceTypeResponse;

import java.time.LocalDateTime;

public record EmployeeResourceResponse(
        Long id,
        EmployeeResourceTypeResponse employeeResourceType,
        String url,
        String fileName,
        String contentType,
        Long sizeInBytes,
        LocalDateTime createdDate
) {
}

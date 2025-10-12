package com.fractal.domain.employee_management.employee.resource.dto;

import org.springframework.web.multipart.MultipartFile;

public record EmployeeResourceRequest(
        Long employeeResourceTypeId,
        MultipartFile file

) { }

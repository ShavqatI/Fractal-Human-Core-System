package com.fractal.domain.employee_management.identification_document.dto;

import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record IdentificationDocumentResponse(
        Long id,
        String identificationType,
        String series,
        Integer number,
        LocalDate issueDate,
        LocalDate expiryDate,
        Integer termInYears,
        String issueOrganization,
        String issueOrganizationAddress,
        String status,
        List<ResourceResponse> resources,
        LocalDateTime createdDate
) {
}

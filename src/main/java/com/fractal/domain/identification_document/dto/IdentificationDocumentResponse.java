package com.fractal.domain.identification_document.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.identification_document.IdentificationDocument;
import com.fractal.domain.identification_document.type.dto.IdentificationDocumentTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record IdentificationDocumentResponse(
        Long id,
        IdentificationDocumentTypeResponse identificationDocumentType,
        String series,
        Integer number,
        LocalDate issueDate,
        LocalDate expiryDate,
        Integer termInYears,
        String issueOrganization,
        String issueOrganizationAddress,
        StatusCompactResponse status,
        List<ResourceResponse> resources,
        LocalDateTime createdDate
) {
}

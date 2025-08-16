package com.fractal.domain.education.document_type.dto;

import java.time.LocalDateTime;

public record EducationDocumentTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}

package com.fractal.domain.identification_document.type.dto;

import java.time.LocalDateTime;

public record IdentificationDocumentTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}

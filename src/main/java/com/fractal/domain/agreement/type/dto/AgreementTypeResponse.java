package com.fractal.domain.agreement.type.dto;

import java.time.LocalDateTime;

public record AgreementTypeResponse(
        Long id,
        String code,
        String name,
        String description,
        String series,
        String templateFileUrl,
        String templateFileFormat,
        LocalDateTime createdDate
) {
}

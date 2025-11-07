package com.fractal.domain.agreement.type.dto;

import com.fractal.domain.dictionary.docuemnt_template_manager.dto.DocumentTemplateManagerResponse;

import java.time.LocalDateTime;

public record AgreementTypeResponse(
        Long id,
        String code,
        String name,
        String description,
        String series,
        DocumentTemplateManagerResponse documentTemplateManager,
        LocalDateTime createdDate
) {
}

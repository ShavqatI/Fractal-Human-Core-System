package com.fractal.domain.integration.mapping.organization.dto;

import java.time.LocalDateTime;

public record DocumentTemplateManagerResponse(
        Long id,
        String code,
        String name,
        String filePath,
        String fileFormat,
        LocalDateTime createdDate

) {

}

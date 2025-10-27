package com.fractal.domain.dictionary.docuemnt_template_manager.dto;

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

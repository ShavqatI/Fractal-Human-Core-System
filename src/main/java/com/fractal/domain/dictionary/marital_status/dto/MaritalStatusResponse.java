package com.fractal.domain.dictionary.marital_status.dto;

import java.time.LocalDateTime;

public record MaritalStatusResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

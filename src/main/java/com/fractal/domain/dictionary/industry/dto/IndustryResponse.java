package com.fractal.domain.dictionary.industry.dto;

import java.time.LocalDateTime;

public record IndustryResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

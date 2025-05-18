package com.fractal.domain.dictionary.nationality.dto;

import java.time.LocalDateTime;

public record NationalityResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

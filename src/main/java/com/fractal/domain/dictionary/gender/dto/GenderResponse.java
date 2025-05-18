package com.fractal.domain.dictionary.gender.dto;

import java.time.LocalDateTime;

public record GenderResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

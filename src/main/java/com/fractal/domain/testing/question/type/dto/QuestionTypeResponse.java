package com.fractal.domain.testing.question.type.dto;

import java.time.LocalDateTime;

public record QuestionTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}

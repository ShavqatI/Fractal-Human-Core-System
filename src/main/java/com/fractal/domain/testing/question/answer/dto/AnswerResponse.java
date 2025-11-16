package com.fractal.domain.testing.question.answer.dto;

import java.time.LocalDateTime;

public record AnswerResponse(
        Long id,
        String text,
        Boolean correct,
        LocalDateTime createdDate
) {
}

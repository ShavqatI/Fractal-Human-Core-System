package com.fractal.domain.testing.test.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.testing.question.dto.QuestionResponse;

import java.time.LocalDateTime;
import java.util.List;

public record TestResponse(
        Long id,
        String title,
        String description,
        Integer durationMinutes,
        List<QuestionResponse> questions,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}

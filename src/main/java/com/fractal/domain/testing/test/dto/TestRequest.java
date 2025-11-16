package com.fractal.domain.testing.test.dto;

import com.fractal.domain.testing.question.dto.QuestionRequest;

import java.util.List;

public record TestRequest(
        String title,
        String description,
        Integer durationMinutes,
        Long statusId,
        List<QuestionRequest> questions

) {
}

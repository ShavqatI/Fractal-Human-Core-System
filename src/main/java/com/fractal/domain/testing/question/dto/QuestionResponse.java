package com.fractal.domain.testing.question.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.testing.question.answer.dto.AnswerResponse;
import com.fractal.domain.testing.question.type.dto.QuestionTypeResponse;

import java.time.LocalDateTime;
import java.util.List;

public record QuestionResponse(
        Long id,
        String text,
        QuestionTypeResponse questionType,
        List<AnswerResponse> answers,
        Integer maxSelectableOptions,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}

package com.fractal.domain.testing.question.dto;

import com.fractal.domain.testing.question.answer.dto.AnswerRequest;

import java.util.List;

public record QuestionRequest(
        String text,
        Long questionTypeId,
        List<AnswerRequest> answers,
        Integer maxSelectableOptions,
        Long statusId

) {
}

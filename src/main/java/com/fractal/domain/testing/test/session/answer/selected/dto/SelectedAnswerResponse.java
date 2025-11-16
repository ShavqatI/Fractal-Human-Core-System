package com.fractal.domain.testing.test.session.answer.selected.dto;

import com.fractal.domain.testing.question.answer.dto.AnswerResponse;

import java.time.LocalDateTime;

public record SelectedAnswerResponse(
        Long id,
        AnswerResponse answer,
        LocalDateTime selectedDate,
        LocalDateTime createdDate
) {
}

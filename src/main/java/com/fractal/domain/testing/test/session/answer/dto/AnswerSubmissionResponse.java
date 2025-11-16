package com.fractal.domain.testing.test.session.answer.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.testing.question.dto.QuestionCompactResponse;
import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerResponse;

import java.time.LocalDateTime;
import java.util.List;

public record AnswerSubmissionResponse(
        Long id,
        QuestionCompactResponse question,
        List<SelectedAnswerResponse> answers,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}

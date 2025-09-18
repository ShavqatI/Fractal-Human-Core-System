package com.fractal.domain.testing.test.session.answer.dto;

import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerRequest;

import java.util.List;

public record AnswerSubmissionRequest(
        Long questionId,
        List<SelectedAnswerRequest> answers,
        Long statusId

) { }

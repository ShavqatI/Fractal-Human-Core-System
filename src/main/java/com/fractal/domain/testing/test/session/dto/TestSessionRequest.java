package com.fractal.domain.testing.test.session.dto;

import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionRequest;

import java.time.LocalDateTime;
import java.util.List;

public record TestSessionRequest(
        Long testId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Long statusId,
        List<AnswerSubmissionRequest> submissions

) { }

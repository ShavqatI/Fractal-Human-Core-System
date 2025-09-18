package com.fractal.domain.testing.test.session.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.testing.test.dto.TestCompactResponse;
import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionResponse;

import java.time.LocalDateTime;
import java.util.List;

public record TestSessionResponse(
        Long id,
        TestCompactResponse test,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Double score,
        List<AnswerSubmissionResponse> submissions,
        StatusCompactResponse status,
        LocalDateTime createdDate
)
{ }

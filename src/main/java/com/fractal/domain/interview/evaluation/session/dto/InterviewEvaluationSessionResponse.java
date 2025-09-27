package com.fractal.domain.interview.evaluation.session.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.interview.evaluation.session.answer.dto.InterviewEvaluationSessionAnswerSubmissionResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewEvaluationSessionResponse(
        Long id,
        LocalDateTime startDate,
        LocalDateTime endDate,
        List<InterviewEvaluationSessionAnswerSubmissionResponse> submissions,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}

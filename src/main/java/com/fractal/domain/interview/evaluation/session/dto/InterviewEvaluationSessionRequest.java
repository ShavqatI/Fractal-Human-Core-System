package com.fractal.domain.interview.evaluation.session.dto;

import com.fractal.domain.interview.evaluation.session.submission.dto.InterviewEvaluationSessionAnswerSubmissionRequest;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewEvaluationSessionRequest(
        LocalDateTime startDate,
        LocalDateTime endDate,
        List<InterviewEvaluationSessionAnswerSubmissionRequest> submissions,
        Long statusId
) {
}
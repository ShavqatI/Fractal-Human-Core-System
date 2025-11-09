package com.fractal.domain.interview.evaluation.session.submission.dto;

import com.fractal.domain.interview.evaluation.session.submission.selected_answer.dto.InterviewEvaluationSessionSelectedAnswerRequest;

import java.util.List;

public record InterviewEvaluationSessionAnswerSubmissionRequest(
        Long questionId,
        List<InterviewEvaluationSessionSelectedAnswerRequest> selectedAnswers,
        Long statusId
) {}

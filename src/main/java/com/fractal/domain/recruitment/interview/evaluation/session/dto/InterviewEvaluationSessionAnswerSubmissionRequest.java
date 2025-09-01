package com.fractal.domain.recruitment.interview.evaluation.session.dto;

import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerRequest;

import java.util.List;

public record InterviewEvaluationSessionAnswerSubmissionRequest(
        Long questionId,
        List<InterviewEvaluationSessionSelectedAnswerRequest> answers,
        Long statusId
) {}

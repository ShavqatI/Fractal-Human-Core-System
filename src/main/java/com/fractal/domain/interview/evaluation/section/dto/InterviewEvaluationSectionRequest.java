package com.fractal.domain.interview.evaluation.section.dto;

import com.fractal.domain.interview.evaluation.section.question.dto.InterviewEvaluationQuestionRequest;

import java.util.List;

public record InterviewEvaluationSectionRequest(
        String code,
        String name,
        List<InterviewEvaluationQuestionRequest> questions,
        List<InterviewEvaluationSectionRequest> children,
        Long statusId
    )

{}

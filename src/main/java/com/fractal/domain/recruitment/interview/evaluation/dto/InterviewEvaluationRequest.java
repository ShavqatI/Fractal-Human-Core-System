package com.fractal.domain.recruitment.interview.evaluation.dto;

import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;

import java.util.List;

public record InterviewEvaluationRequest(
        String code,
        String name,
        List<InterviewEvaluationSectionRequest> sections,
        Long statusId
    )

{}

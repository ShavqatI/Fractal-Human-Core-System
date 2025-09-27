package com.fractal.domain.interview.template.section.dto;

import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionRequest;

import java.util.List;

public record InterviewTemplateSectionRequest(
        String code,
        String name,
        List<InterviewTemplateQuestionRequest> questions,
        List<InterviewTemplateSectionRequest> children,
        Long statusId
    )

{}

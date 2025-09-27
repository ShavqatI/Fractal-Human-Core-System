package com.fractal.domain.interview.template.dto;

import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionRequest;

import java.util.List;

public record InterviewTemplateRequest(
        String code,
        String name,
        List<InterviewTemplateSectionRequest> sections,
        Long statusId
    )

{}

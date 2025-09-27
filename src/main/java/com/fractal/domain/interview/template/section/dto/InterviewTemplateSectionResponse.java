package com.fractal.domain.interview.template.section.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewTemplateSectionResponse(
        Long id,
        String code,
        String name,
        List<InterviewTemplateQuestionResponse> questions,
        List<InterviewTemplateSectionResponse> children,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}

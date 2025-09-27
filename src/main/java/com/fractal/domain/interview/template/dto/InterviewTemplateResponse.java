package com.fractal.domain.interview.template.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewTemplateResponse(
        Long id,
        String code,
        String name,
        List<InterviewTemplateSectionResponse> sections,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}

package com.fractal.domain.interview.template.section.question.answer.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;

public record InterviewTemplateAnswerResponse(
        Long id,
        String text,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}

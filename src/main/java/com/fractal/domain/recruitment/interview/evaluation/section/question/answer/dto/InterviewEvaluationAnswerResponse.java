package com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;

public record InterviewEvaluationAnswerResponse(
        Long id,
        String text,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}

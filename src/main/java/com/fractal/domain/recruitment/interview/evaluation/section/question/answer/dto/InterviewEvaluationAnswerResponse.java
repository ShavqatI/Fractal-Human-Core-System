package com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record InterviewEvaluationAnswerResponse(
        Long id,
        String text,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}

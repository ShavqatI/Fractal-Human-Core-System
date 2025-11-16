package com.fractal.domain.interview.evaluation.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewEvaluationResponse(
        Long id,
        String code,
        String name,
        List<InterviewEvaluationSectionResponse> sections,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}

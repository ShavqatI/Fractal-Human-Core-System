package com.fractal.domain.interview.evaluation.section.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.interview.evaluation.section.question.dto.InterviewEvaluationQuestionResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewEvaluationSectionResponse(
        Long id,
        String code,
        String name,
        List<InterviewEvaluationQuestionResponse> questions,
        List<InterviewEvaluationSectionResponse> children,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}

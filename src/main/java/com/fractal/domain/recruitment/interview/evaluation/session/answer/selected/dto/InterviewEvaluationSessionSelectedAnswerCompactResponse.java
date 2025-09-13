package com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto;

import java.time.LocalDateTime;

public record InterviewEvaluationSessionSelectedAnswerCompactResponse(
        Long id,
        LocalDateTime selectedDate,
        LocalDateTime createdDate

) {}

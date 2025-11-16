package com.fractal.domain.interview.evaluation.session.submission.selected_answer.dto;

import java.time.LocalDateTime;

public record InterviewEvaluationSessionSelectedAnswerCompactResponse(
        Long id,
        LocalDateTime selectedDate,
        LocalDateTime createdDate

) {
}

package com.fractal.domain.interview.evaluation.session.submission.selected_answer.dto;

import com.fractal.domain.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerResponse;

import java.time.LocalDateTime;

public record InterviewEvaluationSessionSelectedAnswerResponse(
        Long id,
        InterviewEvaluationAnswerResponse answer,
        LocalDateTime selectedDate,
        LocalDateTime createdDate

) {
}

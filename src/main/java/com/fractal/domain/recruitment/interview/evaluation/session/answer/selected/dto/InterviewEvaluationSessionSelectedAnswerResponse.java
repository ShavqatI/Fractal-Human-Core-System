package com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto;

import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerResponse;

import java.time.LocalDateTime;

public record InterviewEvaluationSessionSelectedAnswerResponse(
        Long id,
        InterviewEvaluationAnswerResponse answer,
        LocalDateTime selectedDate,

        LocalDateTime createdDate

) {}

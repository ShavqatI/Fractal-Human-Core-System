package com.fractal.domain.recruitment.interview.evaluation.section.question.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerResponse;
import com.fractal.domain.testing.question.type.dto.QuestionTypeResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewEvaluationQuestionCompactResponse(
        Long id,
        String text
) {}

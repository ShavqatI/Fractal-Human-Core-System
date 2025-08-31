package com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.InterviewEvaluationAnswer;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewEvaluationSessionSelectedAnswerResponse(
        Long id,
        InterviewEvaluationAnswerResponse answer,
        LocalDateTime selectedDate,

        LocalDateTime createdDate

) {}

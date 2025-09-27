package com.fractal.domain.interview.template.section.question.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.interview.template.section.question.answer.dto.InterviewTemplateAnswerResponse;
import com.fractal.domain.testing.question.type.dto.QuestionTypeResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InterviewTemplateQuestionResponse(
        Long id,
        String text,
        QuestionTypeResponse questionType,
        List<InterviewTemplateAnswerResponse> answers,
        Integer maxSelectableOptions,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}

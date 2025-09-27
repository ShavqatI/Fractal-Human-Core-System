package com.fractal.domain.interview.template.section.question.dto;

import com.fractal.domain.interview.template.section.question.answer.dto.InterviewTemplateAnswerRequest;

import java.util.List;

public record InterviewTemplateQuestionRequest(
        String text,
        Long questionTypeId,
        List<InterviewTemplateAnswerRequest> answers,
        Integer maxSelectableOptions,
        Long statusId
    )

{}

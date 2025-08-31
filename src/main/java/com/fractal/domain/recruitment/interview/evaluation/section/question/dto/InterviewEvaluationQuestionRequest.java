package com.fractal.domain.recruitment.interview.evaluation.section.question.dto;

import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.InterviewEvaluationAnswer;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerRequest;

import java.util.List;

public record InterviewEvaluationQuestionRequest(
        String text,
        Long questionTypeId,
        List<InterviewEvaluationAnswerRequest> answers,
        Integer maxSelectableOptions,
        Long statusId
    )

{}

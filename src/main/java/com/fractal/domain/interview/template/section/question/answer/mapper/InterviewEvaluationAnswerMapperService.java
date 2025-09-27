package com.fractal.domain.interview.template.section.question.answer.mapper;

import com.fractal.domain.interview.template.section.question.answer.InterviewTemplateAnswer;
import com.fractal.domain.interview.template.section.question.answer.dto.InterviewTemplateAnswerRequest;
import com.fractal.domain.interview.template.section.question.answer.dto.InterviewTemplateAnswerResponse;

public interface InterviewEvaluationAnswerMapperService {
    InterviewTemplateAnswerResponse toDTO(InterviewTemplateAnswer answer);
    InterviewTemplateAnswer toEntity(InterviewTemplateAnswerRequest dto);
    InterviewTemplateAnswer toEntity(InterviewTemplateAnswer answer, InterviewTemplateAnswerRequest dto);
}



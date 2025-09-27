package com.fractal.domain.interview.template.section.question.mapper;

import com.fractal.domain.interview.template.section.question.InterviewTemplateQuestion;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionCompactResponse;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionRequest;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionResponse;

public interface InterviewTemplateQuestionMapperService {
    InterviewTemplateQuestionResponse toDTO(InterviewTemplateQuestion question);
    InterviewTemplateQuestionCompactResponse toCompactDTO(InterviewTemplateQuestion question);
    InterviewTemplateQuestion toEntity(InterviewTemplateQuestionRequest dto);
    InterviewTemplateQuestion toEntity(InterviewTemplateQuestion question, InterviewTemplateQuestionRequest dto);
}



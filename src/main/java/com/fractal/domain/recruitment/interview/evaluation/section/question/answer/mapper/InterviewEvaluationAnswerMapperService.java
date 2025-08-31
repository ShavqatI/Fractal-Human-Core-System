package com.fractal.domain.recruitment.interview.evaluation.section.question.answer.mapper;

import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.InterviewEvaluationAnswer;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerResponse;

public interface InterviewEvaluationAnswerMapperService {
    InterviewEvaluationAnswerResponse toDTO(InterviewEvaluationAnswer answer);
    InterviewEvaluationAnswer toEntity(InterviewEvaluationAnswerRequest dto);
    InterviewEvaluationAnswer toEntity(InterviewEvaluationAnswer answer, InterviewEvaluationAnswerRequest dto);
}



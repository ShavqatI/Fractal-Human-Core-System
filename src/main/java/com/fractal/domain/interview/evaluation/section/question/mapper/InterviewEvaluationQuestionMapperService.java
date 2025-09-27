package com.fractal.domain.interview.evaluation.section.question.mapper;

import com.fractal.domain.interview.evaluation.section.question.InterviewEvaluationQuestion;
import com.fractal.domain.interview.evaluation.section.question.dto.InterviewEvaluationQuestionCompactResponse;
import com.fractal.domain.interview.evaluation.section.question.dto.InterviewEvaluationQuestionRequest;
import com.fractal.domain.interview.evaluation.section.question.dto.InterviewEvaluationQuestionResponse;

public interface InterviewEvaluationQuestionMapperService {
    InterviewEvaluationQuestionResponse toDTO(InterviewEvaluationQuestion question);
    InterviewEvaluationQuestionCompactResponse toCompactDTO(InterviewEvaluationQuestion question);
    InterviewEvaluationQuestion toEntity(InterviewEvaluationQuestionRequest dto);
    InterviewEvaluationQuestion toEntity(InterviewEvaluationQuestion question, InterviewEvaluationQuestionRequest dto);
}



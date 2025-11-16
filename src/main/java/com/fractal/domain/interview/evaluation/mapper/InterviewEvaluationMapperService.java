package com.fractal.domain.interview.evaluation.mapper;

import com.fractal.domain.interview.evaluation.InterviewEvaluation;
import com.fractal.domain.interview.evaluation.dto.InterviewEvaluationRequest;
import com.fractal.domain.interview.evaluation.dto.InterviewEvaluationResponse;

public interface InterviewEvaluationMapperService {
    InterviewEvaluationResponse toDTO(InterviewEvaluation evaluation);

    InterviewEvaluation toEntity(InterviewEvaluationRequest dto);

    InterviewEvaluation toEntity(InterviewEvaluation evaluation, InterviewEvaluationRequest dto);
}



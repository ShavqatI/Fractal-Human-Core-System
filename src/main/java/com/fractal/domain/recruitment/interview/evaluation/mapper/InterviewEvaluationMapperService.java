package com.fractal.domain.recruitment.interview.evaluation.mapper;

import com.fractal.domain.recruitment.interview.evaluation.InterviewEvaluation;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationRequest;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSection;

public interface InterviewEvaluationMapperService {
    InterviewEvaluationResponse toDTO(InterviewEvaluation evaluation);
    InterviewEvaluation toEntity(InterviewEvaluationRequest dto);
    InterviewEvaluation toEntity(InterviewEvaluation evaluation, InterviewEvaluationRequest dto);
}



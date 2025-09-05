package com.fractal.domain.recruitment.interview.mapper;

import com.fractal.domain.recruitment.interview.Interview;
import com.fractal.domain.recruitment.interview.dto.InterviewRequest;
import com.fractal.domain.recruitment.interview.dto.InterviewResponse;
import com.fractal.domain.recruitment.interview.evaluation.InterviewEvaluation;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationRequest;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationResponse;

public interface InterviewMapperService {
    InterviewResponse toDTO(Interview interview);
    Interview toEntity(InterviewRequest dto);
    Interview toEntity(Interview interview, InterviewRequest dto);
}



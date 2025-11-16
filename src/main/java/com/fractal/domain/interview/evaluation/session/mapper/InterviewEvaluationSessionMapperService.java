package com.fractal.domain.interview.evaluation.session.mapper;

import com.fractal.domain.interview.evaluation.session.InterviewEvaluationSession;
import com.fractal.domain.interview.evaluation.session.dto.InterviewEvaluationSessionRequest;
import com.fractal.domain.interview.evaluation.session.dto.InterviewEvaluationSessionResponse;

public interface InterviewEvaluationSessionMapperService {
    InterviewEvaluationSessionResponse toDTO(InterviewEvaluationSession session);

    InterviewEvaluationSession toEntity(InterviewEvaluationSessionRequest dto);

    InterviewEvaluationSession toEntity(InterviewEvaluationSession submission, InterviewEvaluationSessionRequest dto);
}



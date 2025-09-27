package com.fractal.domain.interview.evaluation.session;

import com.fractal.domain.interview.evaluation.session.dto.InterviewEvaluationSessionRequest;
import com.fractal.domain.interview.evaluation.session.dto.InterviewEvaluationSessionResponse;

import java.util.List;


public interface InterviewEvaluationSessionService {
    InterviewEvaluationSession create(Long interviewerId, InterviewEvaluationSessionRequest dto);
    List<InterviewEvaluationSession> getAllByInterviewerId(Long interviewerId);
    InterviewEvaluationSession getById(Long interviewerId , Long id);
    InterviewEvaluationSession getById(Long id);
    InterviewEvaluationSession update(Long interviewerId, Long id, InterviewEvaluationSessionRequest dto);
    void delete(Long interviewerId, Long id);
    InterviewEvaluationSession save(InterviewEvaluationSession session);
    InterviewEvaluationSessionResponse toDTO(InterviewEvaluationSession evaluationSession);
    //InterviewEvaluationSectionCompactResponse toCompactDTO(InterviewEvaluationSection section);


}

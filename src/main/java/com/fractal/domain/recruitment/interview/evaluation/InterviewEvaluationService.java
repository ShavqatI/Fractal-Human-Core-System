package com.fractal.domain.recruitment.interview.evaluation;

import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationRequest;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationResponse;

import java.util.List;


public interface InterviewEvaluationService {
    InterviewEvaluation create(InterviewEvaluationRequest dto);
    List<InterviewEvaluation> getAll();
    InterviewEvaluation getById(Long id);
    InterviewEvaluation update(Long id, InterviewEvaluationRequest dto);
    void deleteById(Long id);
    InterviewEvaluation save(InterviewEvaluation interviewEvaluation);
    InterviewEvaluationResponse toDTO(InterviewEvaluation interviewEvaluation);

}

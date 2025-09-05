package com.fractal.domain.recruitment.interview;

import com.fractal.domain.recruitment.interview.dto.InterviewRequest;
import com.fractal.domain.recruitment.interview.dto.InterviewResponse;
import com.fractal.domain.recruitment.interview.evaluation.InterviewEvaluation;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationRequest;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationResponse;

import java.util.List;


public interface InterviewService {
    Interview create(InterviewRequest dto);
    List<Interview> getAll();
    Interview getById(Long id);
    Interview update(Long id, InterviewRequest dto);
    void deleteById(Long id);
    Interview save(Interview interview);
    InterviewResponse toDTO(Interview interview);

}

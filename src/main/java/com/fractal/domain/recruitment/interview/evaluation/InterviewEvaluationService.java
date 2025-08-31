package com.fractal.domain.recruitment.interview.evaluation;

import com.fractal.domain.navigation.menu.Menu;
import com.fractal.domain.navigation.menu.dto.MenuCompactResponse;
import com.fractal.domain.navigation.menu.dto.MenuRequest;
import com.fractal.domain.navigation.menu.dto.MenuResponse;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationRequest;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSection;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;

import java.util.List;


public interface InterviewEvaluationService {
    InterviewEvaluation create(InterviewEvaluationRequest dto);
    List<InterviewEvaluation> getAll();
    InterviewEvaluation getById(Long id);
    InterviewEvaluation update(Long id, InterviewEvaluationRequest dto);
    void deleteById(Long id);
    InterviewEvaluation save(InterviewEvaluation interviewEvaluation);
    InterviewEvaluationResponse toDTO(InterviewEvaluation interviewEvaluation);
    //MenuCompactResponse toCompactDTO(Menu menu);

}

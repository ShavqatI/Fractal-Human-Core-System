package com.fractal.domain.recruitment.interview.evaluation.section;

import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;

import java.util.List;


public interface InterviewEvaluationSectionService {
    InterviewEvaluationSection create(Long evaluationId, InterviewEvaluationSectionRequest dto);
    List<InterviewEvaluationSection> getAllByInterviewEvaluationId(Long evaluationId);
    InterviewEvaluationSection getById(Long evaluationId , Long id);
    InterviewEvaluationSection getById(Long id);
    InterviewEvaluationSection update(Long evaluationId, Long id,InterviewEvaluationSectionRequest dto);
    void delete(Long evaluationId, Long id);
    InterviewEvaluationSection save(InterviewEvaluationSection section);
    InterviewEvaluationSectionResponse toDTO(InterviewEvaluationSection section);
    InterviewEvaluationSectionCompactResponse toCompactDTO(InterviewEvaluationSection section);

    InterviewEvaluationSection addChild(Long id, InterviewEvaluationSectionRequest dto);
    InterviewEvaluationSection updateChild(Long id, Long childId, InterviewEvaluationSectionRequest dto);
    InterviewEvaluationSection deleteChild(Long id, Long childId);

}

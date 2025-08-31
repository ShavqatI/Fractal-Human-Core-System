package com.fractal.domain.recruitment.interview.evaluation.section;

import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.InterviewEvaluationQuestion;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionResponse;

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
    //InterviewEvaluationQuestionCompactResponse toCompactDTO(InterviewEvaluationSection section);

}

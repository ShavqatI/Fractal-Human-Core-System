package com.fractal.domain.recruitment.interview.evaluation.section.mapper;

import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSection;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.InterviewEvaluationQuestion;

public interface InterviewEvaluationSectionMapperService {
    InterviewEvaluationSectionResponse toDTO(InterviewEvaluationSection section);
    InterviewEvaluationSection toEntity(InterviewEvaluationSectionRequest dto);
    InterviewEvaluationSection toEntity(InterviewEvaluationSection section, InterviewEvaluationSectionRequest dto);
}



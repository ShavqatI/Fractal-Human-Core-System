package com.fractal.domain.recruitment.interview.evaluation.section.mapper;

import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSection;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;

public interface InterviewEvaluationSectionMapperService {
    InterviewEvaluationSectionResponse toDTO(InterviewEvaluationSection section);
    InterviewEvaluationSectionCompactResponse toCompactDTO(InterviewEvaluationSection section);
    InterviewEvaluationSection toEntity(InterviewEvaluationSectionRequest dto);
    InterviewEvaluationSection toEntity(InterviewEvaluationSection section, InterviewEvaluationSectionRequest dto);


}



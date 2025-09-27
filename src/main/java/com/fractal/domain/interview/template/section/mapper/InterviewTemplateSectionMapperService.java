package com.fractal.domain.interview.template.section.mapper;

import com.fractal.domain.interview.template.section.InterviewTemplateSection;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionCompactResponse;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionRequest;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionResponse;

public interface InterviewTemplateSectionMapperService {
    InterviewTemplateSectionResponse toDTO(InterviewTemplateSection section);
    InterviewTemplateSectionCompactResponse toCompactDTO(InterviewTemplateSection section);
    InterviewTemplateSection toEntity(InterviewTemplateSectionRequest dto);
    InterviewTemplateSection toEntity(InterviewTemplateSection section, InterviewTemplateSectionRequest dto);


}



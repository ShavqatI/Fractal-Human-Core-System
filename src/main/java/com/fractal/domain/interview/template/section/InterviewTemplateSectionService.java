package com.fractal.domain.interview.template.section;

import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionCompactResponse;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionRequest;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionResponse;

import java.util.List;


public interface InterviewTemplateSectionService {
    InterviewTemplateSection create(Long templateId, InterviewTemplateSectionRequest dto);
    List<InterviewTemplateSection> getAllByInterviewTemplateId(Long templateId);
    InterviewTemplateSection getById(Long templateId , Long id);
    InterviewTemplateSection getById(Long id);
    InterviewTemplateSection update(Long templateId, Long id, InterviewTemplateSectionRequest dto);
    void delete(Long templateId, Long id);
    InterviewTemplateSection save(InterviewTemplateSection section);
    InterviewTemplateSectionResponse toDTO(InterviewTemplateSection section);
    InterviewTemplateSectionCompactResponse toCompactDTO(InterviewTemplateSection section);

    InterviewTemplateSection addChild(Long id, InterviewTemplateSectionRequest dto);
    InterviewTemplateSection updateChild(Long id, Long childId, InterviewTemplateSectionRequest dto);
    InterviewTemplateSection deleteChild(Long id, Long childId);

}

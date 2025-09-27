package com.fractal.domain.interview.template.section.question;

import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionCompactResponse;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionRequest;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionResponse;

import java.util.List;


public interface InterviewTemplateQuestionService {
    InterviewTemplateQuestion create(Long sectionId, InterviewTemplateQuestionRequest dto);
    List<InterviewTemplateQuestion> getAllBySectionId(Long sectionId);
    InterviewTemplateQuestion getById(Long sectionId , Long id);
    InterviewTemplateQuestion getById(Long id);
    InterviewTemplateQuestion update(Long sectionId, Long id, InterviewTemplateQuestionRequest dto);
    void delete(Long sectionId, Long id);
    InterviewTemplateQuestion save(InterviewTemplateQuestion question);
    InterviewTemplateQuestionResponse toDTO(InterviewTemplateQuestion question);
    InterviewTemplateQuestionCompactResponse toCompactDTO(InterviewTemplateQuestion question);

}

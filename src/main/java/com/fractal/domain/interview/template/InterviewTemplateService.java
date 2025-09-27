package com.fractal.domain.interview.template;

import com.fractal.domain.interview.template.dto.InterviewTemplateRequest;
import com.fractal.domain.interview.template.dto.InterviewTemplateResponse;

import java.util.List;


public interface InterviewTemplateService {
    InterviewTemplate create(InterviewTemplateRequest dto);
    List<InterviewTemplate> getAll();
    InterviewTemplate getById(Long id);
    InterviewTemplate update(Long id, InterviewTemplateRequest dto);
    void deleteById(Long id);
    InterviewTemplate save(InterviewTemplate interviewTemplate);
    InterviewTemplateResponse toDTO(InterviewTemplate interviewTemplate);

}

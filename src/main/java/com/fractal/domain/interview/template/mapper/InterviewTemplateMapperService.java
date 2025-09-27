package com.fractal.domain.interview.template.mapper;

import com.fractal.domain.interview.template.InterviewTemplate;
import com.fractal.domain.interview.template.dto.InterviewTemplateRequest;
import com.fractal.domain.interview.template.dto.InterviewTemplateResponse;

public interface InterviewTemplateMapperService {
    InterviewTemplateResponse toDTO(InterviewTemplate evaluation);
    InterviewTemplate toEntity(InterviewTemplateRequest dto);
    InterviewTemplate toEntity(InterviewTemplate evaluation, InterviewTemplateRequest dto);
}



package com.fractal.domain.interview.mapper;

import com.fractal.domain.interview.dto.InterviewRequest;
import com.fractal.domain.interview.dto.InterviewResponse;
import com.fractal.domain.interview.Interview;

public interface InterviewMapperService {
    InterviewResponse toDTO(Interview interview);
    Interview toEntity(InterviewRequest dto);
    Interview toEntity(Interview interview, InterviewRequest dto);
}



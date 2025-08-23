package com.fractal.domain.recruitment.interview.type;

import com.fractal.domain.recruitment.interview.type.dto.InterviewTypeRequest;
import com.fractal.domain.recruitment.interview.type.dto.InterviewTypeResponse;

import java.util.List;

public interface InterviewTypeService {

    InterviewType create(InterviewTypeRequest dto);
    List<InterviewType> getAll();
    InterviewType getByCode(String code);
    InterviewType getById(Long id);
    InterviewType update(Long id, InterviewTypeRequest dto);
    void deleteById(Long id);
    InterviewTypeResponse toDTO(InterviewType interviewType);
}

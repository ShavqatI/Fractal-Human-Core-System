package com.fractal.domain.recruitment.interview.interviewer.mapper;

import com.fractal.domain.recruitment.interview.dto.InterviewRequest;
import com.fractal.domain.recruitment.interview.interviewer.Interviewer;
import com.fractal.domain.recruitment.interview.interviewer.dto.InterviewerRequest;
import com.fractal.domain.recruitment.interview.interviewer.dto.InterviewerResponse;

public interface InterviewerMapperService {
    InterviewerResponse toDTO(Interviewer interviewer);
    Interviewer toEntity(InterviewerRequest dto);
    Interviewer toEntity(Interviewer interviewer, InterviewRequest dto);
}



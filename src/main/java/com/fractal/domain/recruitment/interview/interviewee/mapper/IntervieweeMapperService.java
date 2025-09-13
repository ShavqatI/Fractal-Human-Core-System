package com.fractal.domain.recruitment.interview.interviewee.mapper;

import com.fractal.domain.recruitment.interview.interviewee.Interviewee;
import com.fractal.domain.recruitment.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.recruitment.interview.interviewee.dto.IntervieweeResponse;

public interface IntervieweeMapperService {
    IntervieweeResponse toDTO(Interviewee interviewee);
    Interviewee toEntity(IntervieweeRequest dto);
    Interviewee toEntity(Interviewee interviewee, IntervieweeRequest dto);
}



package com.fractal.domain.interview.interviewee.mapper;

import com.fractal.domain.interview.interviewee.Interviewee;
import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;

public interface IntervieweeMapperService {
    IntervieweeResponse toDTO(Interviewee interviewee);
    Interviewee toEntity(IntervieweeRequest dto);

}



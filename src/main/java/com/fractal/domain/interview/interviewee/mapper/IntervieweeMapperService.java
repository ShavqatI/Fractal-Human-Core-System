package com.fractal.domain.interview.interviewee.mapper;

import com.fractal.domain.interview.interviewee.Interviewee;
import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;

public interface IntervieweeMapperService {
    IntervieweeResponse toDTO(Interviewee interviewee);

    IntervieweeCompactResponse toCompactDTO(Interviewee interviewee);

    Interviewee toEntity(IntervieweeRequest dto);

}



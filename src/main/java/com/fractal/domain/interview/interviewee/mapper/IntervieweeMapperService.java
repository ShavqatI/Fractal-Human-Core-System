package com.fractal.domain.interview.interviewee.mapper;

import com.fractal.domain.interview.Interview;
import com.fractal.domain.interview.dto.InterviewRequest;
import com.fractal.domain.interview.dto.InterviewResponse;
import com.fractal.domain.interview.interviewee.Interviewee;
import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;

public interface IntervieweeMapperService {
    IntervieweeResponse toDTO(Interviewee interviewee);
    Interviewee toEntity(IntervieweeRequest dto);

}



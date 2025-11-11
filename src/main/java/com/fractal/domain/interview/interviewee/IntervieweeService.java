package com.fractal.domain.interview.interviewee;

import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;

import java.util.List;


public interface IntervieweeService {

    Interviewee create(Long interviewId, IntervieweeRequest dto);
    Interviewee update(Long interviewId, Long id, IntervieweeRequest dto);
    List<Interviewee> getAllByInterviewId(Long interviewerId);
    void delete(Long interviewId, Long id);
    IntervieweeResponse toDTO(Interviewee interviewee);
    IntervieweeCompactResponse toCompactDTO(Interviewee interviewee);
}

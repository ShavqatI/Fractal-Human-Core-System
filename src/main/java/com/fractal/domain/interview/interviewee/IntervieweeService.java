package com.fractal.domain.interview.interviewee;

import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;

import java.util.List;


public interface IntervieweeService {
    Interviewee create(Long interviewId, IntervieweeRequest dto);
    List<Interviewee> getAllByInterviewId(Long interviewerId);
    Interviewee getById(Long interviewId , Long id);
    Interviewee update(Long interviewId, Long id, IntervieweeRequest dto);
    void delete(Long interviewId, Long id);
    IntervieweeResponse toDTO(Interviewee interviewee);
}

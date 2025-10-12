package com.fractal.domain.interview.interviewee;

import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;

import java.util.List;


public interface IntervieweeService {
    List<? extends Interviewee> getAllByInterviewId(Long interviewerId);
    Interviewee getById(Long interviewId , Long id);
    void delete(Long interviewId, Long id);
    IntervieweeResponse toDTO(Interviewee interviewee);
    IntervieweeCompactResponse toCompactDTO(Interviewee interviewee);
}

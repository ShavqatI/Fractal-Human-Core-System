package com.fractal.domain.recruitment.interview.interviewer;

import com.fractal.domain.recruitment.interview.interviewer.dto.InterviewerRequest;
import com.fractal.domain.recruitment.interview.interviewer.dto.InterviewerResponse;

import java.util.List;


public interface InterviewerService {
    Interviewer create(Long interviewId, InterviewerRequest dto);
    List<Interviewer> getAllByInterviewId(Long interviewerId);
    Interviewer getById(Long interviewId , Long id);
    Interviewer getById(Long id);
    Interviewer update(Long interviewId, Long id, InterviewerRequest dto);
    void delete(Long interviewId, Long id);
    Interviewer save(Interviewer interviewer);
    InterviewerResponse toDTO(Interviewer interviewer);


}
